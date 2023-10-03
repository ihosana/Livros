package com.example.livros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.livros.database.BancoDeDados
import com.example.livros.databinding.ActivityListarBinding
import com.example.livros.model.Book

class Listar : AppCompatActivity() {
   lateinit var binding:ActivityListarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_listar)
//
//        val db = Room.databaseBuilder(
//            applicationContext,
//            BancoDeDados::class.java,
//            "banco2.sqlite"
//        ).fallbackToDestructiveMigration()
//            .allowMainThreadQueries().build()
//        db.bookDao().getAll().forEach { Log.i("APPROOM", it.toString()) }


    }
}