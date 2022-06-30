package com.morayl.bottomsheetviewpager

import android.view.View
import com.morayl.bottomsheetviewpager.databinding.IndexItemBinding
import com.morayl.footprintktx.footprint
import com.xwray.groupie.viewbinding.BindableItem

class IndexItem(private val tabIndex: Int) : BindableItem<IndexItemBinding>() {
    override fun bind(viewBinding: IndexItemBinding, position: Int) {
        footprint("$tabIndex  $position")
        viewBinding.indexItemText.text = "$tabIndex  $position"
    }

    override fun getLayout(): Int {
        return R.layout.index_item
    }

    override fun initializeViewBinding(view: View): IndexItemBinding {
        return IndexItemBinding.bind(view)
    }
}