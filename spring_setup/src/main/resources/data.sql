CREATE TABLE users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  role     VARCHAR(20) NOT NULL
);

INSERT INTO users (username, password, role)
VALUES ('testuser2', 'testpass', 'USER');