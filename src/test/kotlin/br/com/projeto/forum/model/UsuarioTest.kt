package br.com.projeto.forum.model

object UsuarioTest {
    fun build() = Usuario(
        id = 1,
        nome = "Pedro",
        email = "pedro@gmail.com",
        password = "123456"
    )
}