CREATE TABLE curso (
    id INT NOT NUlL PRIMARY KEY auto_increment,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL
);

INSERT INTO curso(id,nome,categoria) VALUES(1,'Koltin', 'Programacao');