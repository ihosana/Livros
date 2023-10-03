package com.example.livros.model

import android.media.Rating
import android.text.Editable
import android.widget.RatingBar
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "livros")
data class Book(
    val titulo: String,
    val autor:String,
    val ano:Int,
    val nota: String
) {
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0

}
