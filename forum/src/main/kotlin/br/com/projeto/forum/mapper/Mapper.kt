package br.com.projeto.forum.mapper

interface Mapper<T, U> {

    fun map(t:T):U

}