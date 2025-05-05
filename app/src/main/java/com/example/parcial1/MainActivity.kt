package com.example.parcial1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial1.AlineacionAdapter
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: AlineacionAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView_main)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = AlineacionAdapter(applicationContext)
        recyclerView.adapter = adapter

        adapter.submitList(getListadoAlineacion())
        adapter.onItemClicked = { Alineacion ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("nombre", Alineacion.nombre)
            intent.putExtra("url", Alineacion.url)

            intent.putExtra("posicion", Alineacion.posicion)
            intent.putExtra("edad", Alineacion.edad.toString())
            intent.putExtra("numero", Alineacion.id.toString())

            startActivity(intent)

        }
    }

    private fun getListadoAlineacion(): MutableList<Alineacion>? {
        return mutableListOf(
            Alineacion(1, "Franco armani", "Arquero", 34, "https://img.a.transfermarkt.technology/portrait/header/119634-1727267615.jpg?lm=1"),
            Alineacion(29, "Gonzalo Montiel", "Defensor", 22, "https://img.a.transfermarkt.technology/portrait/header/402733-1668181612.jpg?lm=1"),
            Alineacion(2, "Jonatan Maidana", "Defensor", 33, "https://img.a.transfermarkt.technology/portrait/header/39095-1625770735.png?lm=1"),
            Alineacion(22, "Javier pinola", "Defensor", 32, "https://img.a.transfermarkt.technology/portrait/header/7358-1625770650.png?lm=1"),
            Alineacion(20, "Milton casco", "Defensor", 30, "https://img.a.transfermarkt.technology/portrait/header/115183-1625770873.png?lm=1"),
            Alineacion(10, "Gonzalo Martinez", "Volante", 26, "https://img.a.transfermarkt.technology/portrait/header/281405-1721920823.png?lm=1"),
            Alineacion(23, "Leonardo ponzio", "Volante", 35, "https://img.a.transfermarkt.technology/portrait/header/7987-1625771532.png?lm=1"),
            Alineacion(24, "Enzo perez", "Volante", 32, "https://img.a.transfermarkt.technology/portrait/header/56066-1625771376.png?lm=1"),
            Alineacion(15, "Exequiel palacios", "Volante", 23, "https://img.a.transfermarkt.technology/portrait/header/401578-1695368200.jpg?lm=1"),
            Alineacion(26, "ignacio fernandez", "Volante", 29, "https://img.a.transfermarkt.technology/portrait/header/50669-1693315048.png?lm=1"),
            Alineacion(27, "lucas pratto", "Delantero", 31, "https://img.a.transfermarkt.technology/portrait/header/59596-1715628702.jpg?lm=1"),
        )
    }
}