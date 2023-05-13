CREATE TABLE IF NOT EXISTS users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_roles (
  user_id BIGINT NOT NULL,
  role VARCHAR(255) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO users (username, password, email, name) VALUES
('tiger_lily', 'password1', 'user1@example.com', 'John Doe'),
('sugar_spice', 'password2', 'user2@example.com', 'Jane Doe'),
('shadow_puppet', 'password3', 'user3@example.com', 'Bob Smith'),
('lil_jay', 'password4', 'user4@example.com', 'Jay Lee'),
('kit_kat', 'password5', 'user5@example.com', 'Katie Kim'),
('raj', 'raj', 'raj@example.com', 'Raj Dubey');

INSERT INTO user_roles (user_id, role) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_USER'),
(2, 'ROLE_ADMIN'),
(3, 'ROLE_USER'),
(4, 'ROLE_USER'),
(4, 'ROLE_EDITOR'),
(5, 'ROLE_USER'),
(6, 'ROLE_ADMIN');
