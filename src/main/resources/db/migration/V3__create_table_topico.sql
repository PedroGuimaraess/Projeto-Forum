CREATE TABLE topico (
    id bigint PRIMARY KEY NOT NULL auto_increment,
    titulo VARCHAR(255) NOT NULL,
    mensagem VARCHAR(255) NOT NULL,
    data_criacao datetime,
    status VARCHAR(30) NOT NULL,
    curso_id bigint NOT NULL,
    autor_id bigint NOT NULL,
    FOREIGN KEY (curso_id) REFERENCES curso (id),
    FOREIGN KEY (autor_id) REFERENCES usuario(id)
);