package com.example.livros.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.livros.model.Book

@Dao
interface BookDao {
    @Insert
    fun inserirUnicoLivro(livro1: Book): Long
    @Insert
    fun inserir(livro:Book)

    @Update
    fun atualiza(livro: Book)

    @Delete
    fun removerLivro(livro: Book)

    @Query("SELECT * FROM livros")
    fun getAll(): Array<Book>


}