package com.example.livros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.livros.database.BancoDeDados
import com.example.livros.databinding.ActivityCadastrarBinding
import com.example.livros.model.Book

class Cadastrar : AppCompatActivity() {
    lateinit var binding :ActivityCadastrarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)
        val db = Room.databaseBuilder(
            applicationContext,
            BancoDeDados::class.java,
            "bancoDeDados.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()


        binding=DataBindingUtil.setContentView(this, R.layout.activity_cadastrar)
         binding.cancel.setOnClickListener {
            val i= Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        binding.save.setOnClickListener {

            var titulo=binding.editTextText.text.toString()
            var autor=binding.editTextText2.text.toString()
            var ano = Integer.parseInt(binding.editTextText3.text.toString())
            var nota = binding.ratingBar2.rating.toString()
             val b = Book( titulo,  autor, ano,  nota)
            db.bookDao().inserir(b)
            val i= Intent(this, MainActivity::class.java)
            startActivity(i)

            Toast.makeText(this, "Cadastrado com sucesso.", Toast.LENGTH_SHORT).show()
        }
    }
}