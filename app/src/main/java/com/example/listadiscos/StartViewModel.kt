package com.example.listadiscos

import androidx.lifecycle.ViewModel

class StartViewModel : ViewModel() {
    fun notifyDataChanged() {
        TODO("Not yet implemented")
    }

    private var discos: MutableList<Disco> = mutableListOf()
    private var selectedDisk: Disco? = null

    // Corrected property name from discoss to discos
    val discoss: List<Disco>
        get() = discos.toList()

    var selectDisco: Disco?
        get() = selectedDisk
        set(item) { selectedDisk = item }

    init {
        this.discos.add(
            Disco(
                "13",
                1,
                "Pista de ambiente consiste en ruidos rupestres, tintineos metalicos, salpicaduras, viento y disparos de arcos amortiguados."
            )
        )

        this.discos.add(
            Disco(
                "cat",
                2,
                "Musica tope chula"
            )
        )



    }
}
