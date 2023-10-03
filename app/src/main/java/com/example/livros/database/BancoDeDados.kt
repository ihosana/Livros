package com.example.livros.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.livros.model.Book
import com.example.livros.repository.BookDao

@Database(entities = [Book::class], version = 2)
abstract class BancoDeDados:RoomDatabase() {
    abstract fun bookDao():BookDao
}


