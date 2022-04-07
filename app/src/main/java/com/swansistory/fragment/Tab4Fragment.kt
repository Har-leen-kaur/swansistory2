package com.swansistory.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.swansistory.R
import com.swansistory.adapter.Tab4Adapter
import com.swansistory.viewmodel.MainViewModel

class Tab4Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // implement ur recyclerview
        val adapter = Tab4Adapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapter

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.blogList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }    }


}