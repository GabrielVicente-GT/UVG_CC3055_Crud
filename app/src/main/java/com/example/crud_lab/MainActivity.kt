package com.example.crud_lab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val items : MutableList<String> = mutableListOf()

    private val adaptador = Adaptador({
        clickListener -> showItemClick(clickListener)
    },{longClickListener -> showItemClick2(longClickListener)})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val items : MutableList<String> = mutableListOf()
        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")*/

        //val adaptador = Adaptador(items)


        items.add("Elemento 1")
        items.add("Elemento 2")
        items.add("Elemento 3")

        adaptador.setItems(items)

        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adaptador

        Crear.setOnClickListener{
            items.add("Elemento agregado X")
            adaptador.setItems(items)
        }

    }

    fun showItemClick(position:Int){
        items.removeAt(position)
        adaptador.setItems(items)
    }
    fun showItemClick2(position:Int){
        adaptador.cambiando(position)
    }



}