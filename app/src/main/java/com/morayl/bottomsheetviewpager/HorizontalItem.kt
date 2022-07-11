package com.morayl.bottomsheetviewpager

import android.view.View
import com.morayl.bottomsheetviewpager.databinding.HorizontalItemBinding
import com.morayl.footprintktx.footprint
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.viewbinding.BindableItem

class HorizontalItem(private val tabIndex: Int) : BindableItem<HorizontalItemBinding>() {
    override fun bind(viewBinding: HorizontalItemBinding, position: Int) {
        footprint("$tabIndex  $position")
        val list = List(50) { IndexItem2(tabIndex) }
        viewBinding.horizontalRecycler.adapter = GroupieAdapter().apply {
            addAll(list)
        }
    }

    override fun getLayout(): Int {
        return R.layout.horizontal_item
    }

    override fun initializeViewBinding(view: View): HorizontalItemBinding {
        return HorizontalItemBinding.bind(view)
    }
}