INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('jose', '$2a$10$p3Ou/In4zM8DcaZH7VeK0OCPo/qH6A1bZSMbkYD3B8SOFA4tAgd2y', true,'Jose','Perez','jose-aese@hotmail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin', '$2a$10$sgVqWWtTDQII9dqKqRfMyONicJ4qwloO1KPSHZxzv2h99XXndk0CC', true,'John','Doe','jhon.doe@hotmail.com');


INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');


INSERT INTO usuarios_roles (usuario_id,role_id) VALUES ( 1,1);
INSERT INTO usuarios_roles (usuario_id,role_id) VALUES ( 2,2);
INSERT INTO usuarios_roles (usuario_id,role_id) VALUES ( 2,1);