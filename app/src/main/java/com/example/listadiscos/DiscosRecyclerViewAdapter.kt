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
    private val values: List<Disco>
) : RecyclerView.Adapter<DiscosRecyclerViewAdapter.ViewHolder>() {

    var click: ((Int, Disco) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = position.toString()
        holder.contentView.text = item.nombre
        holder.button.setOnClickListener{
            this.click?.let { it -> it(position, values[position]) }
        }

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content
        val button : Button = binding.button

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}