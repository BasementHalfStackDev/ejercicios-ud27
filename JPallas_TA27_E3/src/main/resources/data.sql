DROP table IF EXISTS user_roles;
DROP table IF EXISTS roles;
DROP table IF EXISTS users;
DROP TABLE IF EXISTS ventas;
DROP TABLE IF EXISTS cajeros;
DROP TABLE IF EXISTS productos;
DROP TABLE IF EXISTS maquinas_registradoras;

CREATE TABLE cajeros(
	id INT NOT NULL AUTO_INCREMENT,
	nombre_apellidos VARCHAR(255) DEFAULT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE productos(
	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(100) DEFAULT NULL,
	precio INT DEFAULT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE maquinas_registradoras(
	id INT NOT NULL AUTO_INCREMENT,
	piso INT DEFAULT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE users(
	id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(120) NOT NULL,
    username VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE ventas(
	id INT NOT NULL AUTO_INCREMENT,
	cajero INT NOT NULL,
	producto INT NOT NULL,
	maquina_registradora INT NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT FK_cajero FOREIGN KEY (cajero) REFERENCES cajeros (id)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FK_producto FOREIGN KEY (producto) REFERENCES productos (id)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FK_maquina_registradora FOREIGN KEY (maquina_registradora)
	REFERENCES maquinas_registradoras (id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE roles(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) DEFAULT NULL
);

CREATE TABLE user_roles(
	user_id INT(20) NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE, 
    FOREIGN KEY (role_id) REFERENCES roles(id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO cajeros(nombre_apellidos) VALUES ('Juan Cuesta');
INSERT INTO cajeros(nombre_apellidos) VALUES ('Juan Cuesta Mas');
INSERT INTO cajeros(nombre_apellidos) VALUES ('Juan Cuesta Menos');
INSERT INTO cajeros(nombre_apellidos) VALUES ('Juan Cuesta MasOMenos');
INSERT INTO cajeros(nombre_apellidos) VALUES ('Juan Cuesta Igual');

INSERT INTO productos(nombre, precio) VALUES ('Manzana', 1);
INSERT INTO productos(nombre, precio) VALUES ('Limon', 999);
INSERT INTO productos(nombre, precio) VALUES ('Videojuego', 69);
INSERT INTO productos(nombre, precio) VALUES ('Revista', 2);
INSERT INTO productos(nombre, precio) VALUES ('Guitarra', 200);

INSERT INTO maquinas_registradoras(piso) VALUES (1);
INSERT INTO maquinas_registradoras(piso) VALUES (2);
INSERT INTO maquinas_registradoras(piso) VALUES (1);
INSERT INTO maquinas_registradoras(piso) VALUES (2);
INSERT INTO maquinas_registradoras(piso) VALUES (1);

INSERT INTO ventas(cajero, producto, maquina_registradora) VALUES (1, 1, 1);
INSERT INTO ventas(cajero, producto, maquina_registradora) VALUES (2, 2, 2);
INSERT INTO ventas(cajero, producto, maquina_registradora) VALUES (3, 3, 3);
INSERT INTO ventas(cajero, producto, maquina_registradora) VALUES (4, 4, 4);
INSERT INTO ventas(cajero, producto, maquina_registradora) VALUES (5, 5, 5);

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO users(email, password, username) VALUES ('admin@TA27.com', '$2a$10$mR4MU5esBbUd6JWuwWKTA.tRy.jo4d4XRkgnamcOJfw5pJ8Ao/RDS', 'admin');
INSERT INTO users(email, password, username) VALUES ('user@TA27.com', '$2a$10$mR4MU5esBbUd6JWuwWKTA.tRy.jo4d4XRkgnamcOJfw5pJ8Ao/RDS', 'user');

INSERT INTO user_roles(user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles(user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles(user_id, role_id) VALUES (2, 1);


