package com.example.parcial1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity: AppCompatActivity() {

    private lateinit var textView_nombre: TextView
    private lateinit var imageView_image: ImageView
    private lateinit var textView_posicion: TextView
    private lateinit var textView_edad: TextView
    private lateinit var textView_numero: TextView
    private lateinit var button_volver: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textView_nombre = findViewById(R.id.textView_nombre)
        imageView_image = findViewById(R.id.imageView_image)
        textView_posicion = findViewById(R.id.textView_posicion)
        textView_edad = findViewById(R.id.textView_edad)
        textView_numero = findViewById(R.id.textView_numero)
        button_volver = findViewById(R.id.button_volver)



        val bundle = intent.extras
        val nombre = bundle?.getString("nombre", "")
        val url = bundle?.getString("url") ?: ""

        textView_posicion.text = bundle?.getString("posicion", "")
        textView_edad.text = "Edad: " + bundle?.getString("edad", "")
        textView_numero.text = "Numero: " + bundle?.getString("numero", "")

        button_volver.setOnClickListener {
            finish()
        }


        textView_nombre.text = nombre
        Glide.with(applicationContext)
            .load(url)
            .into(imageView_image)


        }
    }
