package com.example.listadiscos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    private val viewModel: StartViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el diseño de fragmento_list.xml en la vista
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // Configura el RecyclerView para que aparezca la lista de discos buscando su id
        val recyclerView: RecyclerView = view.findViewById(R.id.listaDiscos)
        val adaptador = DiscosRecyclerViewAdapter(this.viewModel.discoList)

        // Define la acción a realizar cuando se hace clic en un elemento del RecyclerView
        adaptador.click = { position, disco ->
            // Almacenar el disco seleccionado en el ViewModel compartido
            this.viewModel.selectDataDisco = disco
            val fm: FragmentManager = parentFragmentManager

            // Verifica si el dispositivo no está en orientación "landscape"
            if (!resources.getBoolean(R.bool.land)) {
                // Reemplazar el fragmento actual con el DetailFragment
                fm.commit {
                    replace(R.id.fragmentContainerView, DetailFragment.newInstance()) //Se crea una nueva instancia de Detail.
                    addToBackStack("replacement")
                }
            } else {
                // Si está en orientación "landscape", actualizar el DetailFragment existente
                val contenedor = view.findViewById<FragmentContainerView>(R.id.detailfragmentContainerView)
                val fragmentManager = childFragmentManager
                var fragment = fragmentManager.findFragmentById(contenedor?.id ?: -1)
                if (fragment != null && fragment is DetailFragment) {
                    fragment.update()
                }
            }
        }

        // Configurar el botón para agregar un nuevo disco
        view.findViewById<Button>(R.id.newDiscoButton).setOnClickListener {
            val fm: FragmentManager = parentFragmentManager
            fm.commit {
                replace(R.id.fragmentContainerView, AddFragment.newInstance()) //Al presionar el boton se creará una nueva instancia del Addfragment
                addToBackStack("replacement")
            }
        }

        // Configurar el LayoutManager y el adaptador para el RecyclerView
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adaptador

        return view // Devuelve la vista inflada
    }
    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}
