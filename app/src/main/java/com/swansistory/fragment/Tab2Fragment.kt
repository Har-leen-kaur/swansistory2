package com.swansistory.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.swansistory.R
import com.swansistory.adapter.Tab2Adapter
import com.swansistory.viewmodel.MainViewModel

class Tab2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mAdapter = Tab2Adapter()

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = mAdapter
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

//        viewModel.setPlaceFavourite(Place(1,"Mumbai",true))
        viewModel.favPlaceList.observe(viewLifecycleOwner) {
            Log.i("GoogleIO",it.toString())
            mAdapter.submitList(it)
        }
    }

}