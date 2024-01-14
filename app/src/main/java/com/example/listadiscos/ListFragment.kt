package com.example.listadiscos

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    private lateinit var view: View
    private val viewModel: StartViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        view = inflater.inflate(R.layout.fragment_list, container, false)
        val recyclerView : RecyclerView = view.findViewById(R.id.listaDiscos)
        var adaptador = DiscosRecyclerViewAdapter(this.viewModel.discoss)
        adaptador.click = { position, disco ->
            run {
               this.viewModel.selectDisco = disco
               val fm : FragmentManager = parentFragmentManager
               if(!resources.getBoolean(R.bool.land)) {
                   fm.commit{
                        replace(R.id.fragmentContainerView, Detail.newInstance())
                       addToBackStack("Remplazo")
                   }

               }
                else{
                    val contenedor = view.findViewById<FragmentContainerView>(R.id.detailfragmentContainerView)
                    val fragmentManager = childFragmentManager
                    var fragment = fragmentManager.findFragmentById(contenedor?.id ?: -1)
                    if(fragment != null && fragment is Detail){
                        (fragment as Detail).update()
                    }
               }
            }
        }

        val layoutManager = GridLayoutManager(this.context, 2)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adaptador
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ListFragment()
    }
}
