package com.swansistory.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.swansistory.R
import com.swansistory.adapter.Tab1Adapter
import com.swansistory.viewmodel.MainViewModel


class Tab1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mAdapter = Tab1Adapter()

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = mAdapter
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.placeList.observe(viewLifecycleOwner) {
            mAdapter.submitList(it)
        }

    }
}