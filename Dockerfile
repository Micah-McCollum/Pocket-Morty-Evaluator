



# syntax=docker/dockerfile:1

# Comments are provided throughout this file to help you get started.
# If you need more help, visit the Dockerfile reference guide at
# https://docs.docker.com/go/dockerfile-reference/

# Want to help us make this template better? Share your feedback here: https://forms.gle/ybq9Krt8jtBL3iCk7

################################################################################

# GRADLE

# Create a stage for resolving and downloading dependencies.
FROM gradle:8.8-jdk21 AS build
WORKDIR /workspace

# Copy the mvnw wrapper with executable permissions.
COPY gradlew gradlew
COPY gradle/ gradle/
RUN chmod +x gradlew

COPY settings.gradle* build.gradle* ./

# Prime Gradle cache (no sources yet -> reuses layers when only code changes)
RUN --mount=type=cache,target=/home/gradle/.gradle ./gradlew --version

# Now bring in sources (invalidates only this layer when code changes)
COPY src/ src/

# Build an executable jar; for non-Spring apps use `jar` instead of `bootJar`
RUN --mount=type=cache,target=/home/gradle/.gradle \
    ./gradlew clean bootJar -x test

################################################################################

# Create a stage for building the application based on the stage with downloaded dependencies.
# This Dockerfile is optimized for Java applications that output an uber jar, which includes
# all the dependencies needed to run your app inside a JVM. If your app doesn't output an uber
# jar and instead relies on an application server like Apache Tomcat, you'll need to update this
# stage with the correct filename of your package and update the base image of the "final" stage
# use the relevant app server, e.g., using tomcat (https://hub.docker.com/_/tomcat/) as a base image.


################################################################################

# Create a new stage for running the application that contains the minimal
# runtime dependencies for the application. This often uses a different base
# image from the install or build stage where the necessary files are copied
# from the install stage.
#
# The example below uses eclipse-turmin's JRE image as the foundation for running the app.
# By specifying the "21-jre-jammy" tag, it will also use whatever happens to be the
# most recent version of that tag when you build your Dockerfile.
# If reproducibility is important, consider using a specific digest SHA, like
# eclipse-temurin@sha256:99cede493dfd88720b610eb8077c8688d3cca50003d76d1d539b0efc8cca72b4.
FROM eclipse-temurin:21-jre-jammy AS runtime
WORKDIR /app

# Copy the single jar produced by Gradle
ARG JAR_PATH=/workspace/build/libs/*.jar
COPY --from=build ${JAR_PATH} /app/app.jar

COPY docker/app-entrypoint.sh /app/app-entrypoint.sh
RUN chmod +x /app/app-entrypoint.sh

EXPOSE 8080
ENTRYPOINT ["/app/app-entrypoint.sh"]
