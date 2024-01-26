package com.example.listadiscos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

class StartFragment : Fragment() {


    companion object {
        fun newInstance() = StartFragment()
    }

    private lateinit var view: View
    private lateinit var starView : StartViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el diseño de fragment_start.xml en la vista
        view = inflater.inflate(R.layout.fragment_start, container, false)

        // Establece el mensaje de bienvenida en un TextView
        view.findViewById<TextView>(R.id.textView).setText("Bienvenido!")

        // Define la acción a realizar cuando se hace clic en una imagen
        view.findViewById<ImageView>(R.id.imageView).setOnClickListener{
            val fm : FragmentManager = parentFragmentManager
            fm.commit {
                // Reemplaza el fragmento actual con el ListFragment y lo agrega a la pila de retroceso
                replace(R.id.fragmentContainerView, ListFragment.newInstance())
                addToBackStack("remplacement")
            }
            true
        }

        return view // Devuelve la vista inflada
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // Inicializa el ViewModel de StartViewModel
        starView = ViewModelProvider(this).get(StartViewModel::class.java)
        // TODO: Utiliza el ViewModel si es necesario
    }
}
