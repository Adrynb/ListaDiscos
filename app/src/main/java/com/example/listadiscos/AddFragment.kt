package com.example.listadiscos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.activityViewModels

class AddFragment : Fragment() {

    private lateinit var view: View
    private val startViewModel: StartViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add, container, false)

        val addNombreText =  view.findViewById<EditText>(R.id.addNombreText)
        val addDescriptionText = view.findViewById<EditText>(R.id.addDescripcionText)



        view.findViewById<Button>(R.id.añadirDiscoButton).setOnClickListener{

            val nombre = addNombreText.text.toString()
            val description = addDescriptionText.text.toString()

            startViewModel.addDisco(Disco(nombre, description))


            requireActivity().supportFragmentManager.popBackStack()

        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            AddFragment().apply {

                }
            }
    }
