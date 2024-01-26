package com.example.listadiscos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels

class AddFragment : Fragment() {

    private lateinit var view: View
    private val startViewModel: StartViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el diseño de fragment_add.xml en la vista
        view = inflater.inflate(R.layout.fragment_add, container, false)

        // Obtiene referencias a los elementos de la interfaz de usuario
        val addNombreText = view.findViewById<EditText>(R.id.addNombreText)
        val addDescriptionText = view.findViewById<EditText>(R.id.addDescripcionText)

        // Define la acción a realizar cuando se hace clic en el botón de añadir disco
        view.findViewById<Button>(R.id.añadirDiscoButton).setOnClickListener{

            // Obtiene los datos ingresados por el usuario
            val nombre = addNombreText.text.toString()
            val description = addDescriptionText.text.toString()

            // Agrega un nuevo disco
            startViewModel.addDisco(DataDisco(nombre, description))

            // Regresa al fragmento anterior
            requireActivity().supportFragmentManager.popBackStack()
        }

        return view // Devuelve el view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AddFragment().apply {

            }
    }
}
