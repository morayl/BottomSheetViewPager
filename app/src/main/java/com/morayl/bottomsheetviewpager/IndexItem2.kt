package com.morayl.bottomsheetviewpager

import android.view.View
import com.morayl.bottomsheetviewpager.databinding.IndexItem2Binding
import com.morayl.footprintktx.footprint
import com.xwray.groupie.viewbinding.BindableItem

class IndexItem2(private val tabIndex: Int) : BindableItem<IndexItem2Binding>() {
    override fun bind(viewBinding: IndexItem2Binding, position: Int) {
        footprint("$tabIndex  $position")
        viewBinding.indexItemText.text = "$tabIndex  $position"
    }

    override fun getLayout(): Int {
        return R.layout.index_item2
    }

    override fun initializeViewBinding(view: View): IndexItem2Binding {
        return IndexItem2Binding.bind(view)
    }
}