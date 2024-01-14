package com.example.listadiscos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Detail.newInstance] factory method to
 * create an instance of this fragment.
 */
class Detail : Fragment() {

    private lateinit var view : View
    private val startViewModel: StartViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    public fun update(){
        this.startViewModel.selectDisco?.let {
            view.findViewById<TextView>(R.id.nombreDisco).setText(it.nombre)
            view.findViewById<TextView>(R.id.discoID).setText(it.numeroID.toString())
            view.findViewById<TextView>(R.id.discoDescription).setText(it.descripcion)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail, container, false)
        this.update()

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Detail.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            Detail().apply {

            }
    }
}