CREATE TABLE usuario (
    id INT PRIMARY KEY NOT NULL auto_increment,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

INSERT INTO usuario(id,nome,email) VALUES(1,'Ana da Silva', 'ana@gmail.com');
INSERT INTO usuario(id,nome,email) VALUES(2,'Leticia da Silva', 'le@gmail.com');
