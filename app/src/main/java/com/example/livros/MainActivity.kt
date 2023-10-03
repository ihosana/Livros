package com.example.livros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.livros.database.BancoDeDados
import com.example.livros.databinding.ActivityMainBinding
import com.example.livros.model.Book

class MainActivity : AppCompatActivity() {
   lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.cadastrar.setOnClickListener {
            val i= Intent(this, Cadastrar::class.java)
            startActivity(i)
        }
        binding.listar.setOnClickListener {
            val i= Intent(this, Listar::class.java)
            startActivity(i)
        }
    }
}