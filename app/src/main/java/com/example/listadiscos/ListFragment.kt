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
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.listaDiscos)
        val adaptador = DiscosRecyclerViewAdapter(this.viewModel.discoss)

        adaptador.click = { position, disco ->

            this.viewModel.selectDisco = disco
            val fm: FragmentManager = parentFragmentManager

            if (!resources.getBoolean(R.bool.land)) {
                println("Entras aqui?")

                fm.commit {
                    replace(R.id.fragmentContainerView, DetailFragment.newInstance())
                    addToBackStack("replacement")
                }
            } else {

                println("Entras pepe?")
                val contenedor = view.findViewById<FragmentContainerView>(R.id.detailfragmentContainerView)
                val fragmentManager = childFragmentManager
                var fragment = fragmentManager.findFragmentById(contenedor?.id ?: -1)
                if (fragment != null && fragment is DetailFragment) {
                    fragment.update()
                }

            }
        }

        view.findViewById<Button>(R.id.newDiscoButton).setOnClickListener {
            val fm: FragmentManager = parentFragmentManager
            fm.commit {
                replace(R.id.fragmentContainerView, AddFragment.newInstance())
                addToBackStack("replacement")
            }
        }

        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adaptador

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}
