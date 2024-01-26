package com.example.listadiscos

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.example.listadiscos.placeholder.PlaceholderContent.PlaceholderItem
import com.example.listadiscos.databinding.FragmentItemBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class DiscosRecyclerViewAdapter(
    private val values: List<DataDisco>
) : RecyclerView.Adapter<DiscosRecyclerViewAdapter.ViewHolder>() {

    // Función de clic definida como lambda que toma la posición y el objeto DataDisco como parámetros
    var click: ((Int, DataDisco) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Infla la vista del elemento de la lista utilizando el enlace de datos FragmentItemBinding
        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // Método llamado para vincular los datos del elemento en la posición dada con la vista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        // Establece el texto del TextView con el nombre del disco
        holder.contentView.text = item.nombre
        // Establece el texto del TextView con la posición del disco en la lista
        holder.idView.text = position.toString()
        // Define la acción a realizar cuando se hace clic en el botón
        holder.button.setOnClickListener {
            // Invoca la función de clic con la posición y el objeto DataDisco como argumentos
            this.click?.let { it(position, values[position]) }
        }
    }

    // Método que devuelve la cantidad de elementos en la lista
    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content
        val button: Button = binding.button

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}
