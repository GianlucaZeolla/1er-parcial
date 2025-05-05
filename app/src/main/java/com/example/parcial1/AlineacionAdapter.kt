package com.example.parcial1

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AlineacionAdapter(val context: Context) : ListAdapter<Alineacion, AlineacionAdapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClicked: (Alineacion) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val id: TextView = view.findViewById(R.id.textView_id)
        private val nombre: TextView = view.findViewById(R.id.textView_nombre)
        private val posicion: TextView = view.findViewById(R.id.textView_posicion)
        private val edad: TextView = view.findViewById(R.id.textView_edad)
        private val url: ImageView = view.findViewById(R.id.imageView)

        fun bind(alineacion: Alineacion) {
            id.text = "Nro: " + alineacion.id.toString()
            nombre.text = " " + alineacion.nombre
            posicion.text = "posicion: " + alineacion.posicion.toString()
            edad.text = "edad: " + alineacion.edad.toString()


            Glide.with(context)
                .load(alineacion.url)
                .into(url)

            view.setOnClickListener{
                onItemClicked(alineacion)
            }



        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlineacionAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: AlineacionAdapter.ViewHolder, position: Int) {
        val alineacion = getItem(position)
        holder.bind(alineacion)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Alineacion>() {
        override fun areItemsTheSame(oldItem: Alineacion, newItem: Alineacion): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Alineacion, newItem: Alineacion): Boolean {
            return oldItem == newItem

        }
        }
}
