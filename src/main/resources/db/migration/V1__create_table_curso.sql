CREATE TABLE curso (
    id bigint NOT NUlL auto_increment,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO curso VALUES(1,'Kotlin', 'Programacao');
INSERT INTO curso VALUES(2,'HTML', 'Front-end');