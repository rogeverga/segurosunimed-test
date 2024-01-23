INSERT INTO customer (id, name, email, gender) VALUES (1, 'Homem Aranha', 'aranha@vingadores.com', 'M');
INSERT INTO customer (id, name, email, gender) VALUES (2, 'Thor', 'thor@vingadores.com', 'M');
INSERT INTO customer (id, name, email, gender) VALUES (3, 'Viuva Negra', 'viuva@vingadores.com', 'F');
INSERT INTO customer (id, name, email, gender) VALUES (4, 'Namor', 'namor@vingadores.com', 'M');
INSERT INTO customer (id, name, email, gender) VALUES (5, 'Gamora', 'gamora@vingadores.com', 'F');

INSERT INTO address (id, city, complement, federative_unit, neighborhood, number, street, zip_code, customer_id) VALUES (1, 'São Paulo', 'Apartamento 42', 'SP', 'República', 403, 'Avenida Ipiranga', '01039000', 1)
INSERT INTO address (id, city, complement, federative_unit, neighborhood, number, street, zip_code, customer_id) VALUES (2, 'São Paulo', NULL, 'SP', 'Morumbi', 32, 'Rua Pompeu de Toledo', '05653070', 2)
INSERT INTO address (id, city, complement, federative_unit, neighborhood, number, street, zip_code, customer_id) VALUES (3, 'Campinas', NULL, 'SP', 'Taquaral', NULL, 'Avenida Taquaral', '01039000', 3)
INSERT INTO address (id, city, complement, federative_unit, neighborhood, number, street, zip_code, customer_id) VALUES (4, 'Curitiba', 'Apartamento 42', 'PR', 'Boqueirão', 403, 'Avenida Ipiranga', '12223345', 4)
INSERT INTO address (id, city, complement, federative_unit, neighborhood, number, street, zip_code, customer_id) VALUES (5, 'Goiânia', NULL, 'GO', 'República', 403, 'Avenida Brasil', '28998764', 5)