package com.morayl.bottomsheetviewpager

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupieAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ContentFragment : Fragment(R.layout.fragment_content) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            // 遅れてRecyclerViewが更新されてもスクロールできることの確認
            delay(2000)
            val index = requireArguments().getInt("index")
            val groupieAdapter = GroupieAdapter()
            val size = if (index == 0) {
                5
            } else {
                50
            }
            groupieAdapter.add(HorizontalItem(index))
            List(size) { IndexItem(index) }.forEach {
                groupieAdapter.add(it)
            }
            groupieAdapter.add(VerticalItem(index))
            view.findViewById<RecyclerView>(R.id.content_recycler).apply {
                adapter = groupieAdapter
            }
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