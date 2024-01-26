package com.example.listadiscos

import androidx.lifecycle.ViewModel


class StartViewModel : ViewModel() {

    fun notifyDataChanged() {
        TODO("Not yet implemented")
    }

    // Lista mutable de discos y disco seleccionado
    private var dataDiscoMutableList: MutableList<DataDisco> = mutableListOf()
    private var selectedDisk: DataDisco? = null

    // Propiedad de solo lectura que devuelve la lista de discos
    val discoList: List<DataDisco>
        get() = dataDiscoMutableList.toList()

    // Propiedad para obtener y establecer el disco seleccionado
    var selectDataDisco: DataDisco?
        get() = selectedDisk
        set(item) { selectedDisk = item }

    init {
        // Agrega algunos discos predefinidos a la lista mutable
        this.dataDiscoMutableList.add(
            DataDisco(
                "13",
                "Pista de ambiente consiste en ruidos rupestres, tintineos metalicos, salpicaduras, viento y disparos de arcos amortiguados."
            )
        )

        this.dataDiscoMutableList.add(
            DataDisco(
                "cat",
                "Musica tope chula"
            )
        )
    }

    // Método para agregar un nuevo disco a la lista
    fun addDisco(dataDisco: DataDisco) {
        dataDiscoMutableList.add(dataDisco)
    }
}
