DROP TABLE IF EXISTS suministra;
DROP TABLE IF EXISTS proveedores;
DROP TABLE IF EXISTS piezas;

CREATE TABLE piezas(
	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(100) DEFAULT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE proveedores(
	id CHAR(4) NOT NULL,
	nombre VARCHAR(100) DEFAULT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE suministra(
	id INT NOT NULL AUTO_INCREMENT,
	pieza INT NOT NULL,
	proveedor CHAR(4) NOT NULL,
	precio INT NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT FK_pieza FOREIGN KEY (pieza) REFERENCES piezas (id)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FK_proveedor FOREIGN KEY (proveedor) REFERENCES proveedores (id)
	ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO piezas(nombre) VALUES ('Tornillo');
INSERT INTO piezas(nombre) VALUES ('Arandela');
INSERT INTO piezas(nombre) VALUES ('Engranaje');
INSERT INTO piezas(nombre) VALUES ('Muelle');
INSERT INTO piezas(nombre) VALUES ('Remache');

INSERT INTO proveedores(id, nombre) VALUES ('PRO1', 'Mahle');
INSERT INTO proveedores(id, nombre) VALUES ('PRO2', 'Bosch');
INSERT INTO proveedores(id, nombre) VALUES ('PRO3', 'Rheinmetall');
INSERT INTO proveedores(id, nombre) VALUES ('PRO4', 'Balay');
INSERT INTO proveedores(id, nombre) VALUES ('PRO5', 'Remaches Jomacho');

INSERT INTO suministra(pieza, proveedor, precio) VALUES (1, 'PRO1', 2);
INSERT INTO suministra(pieza, proveedor, precio) VALUES (2, 'PRO2', 3);
INSERT INTO suministra(pieza, proveedor, precio) VALUES (3, 'PRO3', 1);
INSERT INTO suministra(pieza, proveedor, precio) VALUES (4, 'PRO4', 4);
INSERT INTO suministra(pieza, proveedor, precio) VALUES (5, 'PRO5', 10);


