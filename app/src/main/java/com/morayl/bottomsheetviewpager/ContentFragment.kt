package com.morayl.bottomsheetviewpager

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupieAdapter

class ContentFragment : Fragment(R.layout.fragment_content) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val index = requireArguments().getInt("index")
        val groupieAdapter = GroupieAdapter()
        val size = if (index == 0) {
            3
        } else {
            100
        }
        List(size) { IndexItem(index) }.forEach {
            groupieAdapter.add(it)
        }
        view.findViewById<RecyclerView>(R.id.content_recycler).apply {
            adapter = groupieAdapter
        }
    }

    companion object {
        fun newInstance(index: Int): ContentFragment {
            return ContentFragment().apply {
                arguments = bundleOf("index" to index)
            }
        }
    }
}