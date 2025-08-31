#!/usr/bin/env sh
set -eu

# Read the password from the Docker secret (strip trailing newline)
if [ -f /run/secrets/db_app_password ]; then
  SPRING_DATASOURCE_PASSWORD="$(tr -d '\r\n' < /run/secrets/db_app_password)"
  export SPRING_DATASOURCE_PASSWORD
fi

# Optional: prove it's there (length only, not the value)
if [ -z "${SPRING_DATASOURCE_PASSWORD:-}" ]; then
  echo "WARN: SPRING_DATASOURCE_PASSWORD is empty or missing"
else
  echo "INFO: SPRING_DATASOURCE_PASSWORD loaded (length: ${#SPRING_DATASOURCE_PASSWORD})"
fi

exec java ${JAVA_OPTS:-} -jar /app/app.jar