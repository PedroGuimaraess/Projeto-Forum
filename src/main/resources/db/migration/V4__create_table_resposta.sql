CREATE TABLE resposta(
    id INT NOT NUlL PRIMARY KEY auto_increment,
    mensagem VARCHAR(300) NOT NULL,
    data_criacao datetime,
    topico_id bigint NOT NULL,
    autor_id bigint NOT NULL,
    solucao BOOLEAN NOT NULL,
    FOREIGN KEY (topico_id) REFERENCES topico(id),
    FOREIGN KEY (autor_id) REFERENCES usuario(id)
);