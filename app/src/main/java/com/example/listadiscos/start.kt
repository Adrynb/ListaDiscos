package com.example.listadiscos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.listadiscos.R.layout.fragment_start

class start : Fragment() {

    companion object {
        fun newInstance() = start()
    }

    private lateinit var viewModel: View
    private lateinit var starView : StartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = inflater.inflate(R.layout.fragment_start, container, false)
        viewModel.findViewById<ImageView>(R.id.imageView).setOnClickListener{
            val fm : FragmentManager = parentFragmentManager
            fm.commit {

            }
        }
        return inflater.inflate(fragment_start, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        starView = ViewModelProvider(this).get(StartViewModel::class.java)
        // TODO: Use the ViewModel
    }

}