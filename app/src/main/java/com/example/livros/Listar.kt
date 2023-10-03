package com.example.livros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.livros.database.BancoDeDados
import com.example.livros.databinding.ActivityListarBinding
import com.example.livros.model.Book

class Listar : AppCompatActivity() {
   lateinit var binding:ActivityListarBinding
   var i :Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_listar)
        val db = Room.databaseBuilder(
            applicationContext,
            BancoDeDados::class.java,
            "bancoDeDados.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()
         binding.tituloView.text=db.bookDao().getAll().get(i).titulo
         binding.textoView.text=db.bookDao().getAll().get(i).autor
         binding.anoView.text=db.bookDao().getAll().get(i).ano.toString()
         binding.notaView.text=db.bookDao().getAll().get(i).nota

        binding.button5.setOnClickListener {
            var tamanho= Integer.parseInt( db.bookDao().getAll().size.toString())
           if(i < tamanho-1){
               binding.tituloView.text=db.bookDao().getAll().get(i+1).titulo
               binding.textoView.text=db.bookDao().getAll().get(i+1).autor
               binding.anoView.text=db.bookDao().getAll().get(i+1).ano.toString()
               binding.notaView.text=db.bookDao().getAll().get(i+1).nota
               i++;
           }else{
               Toast.makeText(this, "Limite da lsita de livros alcançado.", Toast.LENGTH_SHORT).show()

           }



        }

        binding.button3.setOnClickListener {
          if(i>1){
              binding.tituloView.text=db.bookDao().getAll().get(i-1).titulo
              binding.textoView.text=db.bookDao().getAll().get(i-1).autor
              binding.anoView.text=db.bookDao().getAll().get(i-1).ano.toString()
              binding.notaView.text=db.bookDao().getAll().get(i-1).nota
              i--;
          }else{
              Toast.makeText(this, "Inicio da lista alcançado.", Toast.LENGTH_SHORT).show()

          }
        }

    }
}