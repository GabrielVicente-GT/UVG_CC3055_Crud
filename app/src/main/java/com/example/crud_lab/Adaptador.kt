package com.example.crud_lab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_lista.view.*

class Adaptador(private val clickListener: (Int) -> Unit,private val longClickListener: (Int) -> Unit) : RecyclerView.Adapter<Adaptador.ItemsViewHolder>() {

    private var items: MutableList<String> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista,parent,false)
        return ItemsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item,clickListener,longClickListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(nuevosItems:MutableList<String>){
        this.items = nuevosItems
        notifyDataSetChanged()
    }

    fun cambiando(position: Int) {
        items[position] = "Nuevo item"
        notifyDataSetChanged()
    }

    class ItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item:String,listener: (Int) -> Unit,longClickListener: (Int) -> Unit )=with(itemView){
            txtTitulo.text = item
            setOnLongClickListener{
                longClickListener(adapterPosition)
                true
            }
            setOnClickListener{listener (adapterPosition)}

        }
    }
}