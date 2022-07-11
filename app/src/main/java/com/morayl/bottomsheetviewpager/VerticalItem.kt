package com.morayl.bottomsheetviewpager

import android.view.View
import com.morayl.bottomsheetviewpager.databinding.VerticalItemBinding
import com.morayl.footprintktx.footprint
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.viewbinding.BindableItem

class VerticalItem(private val tabIndex: Int) : BindableItem<VerticalItemBinding>() {
    override fun bind(viewBinding: VerticalItemBinding, position: Int) {
        footprint("$tabIndex  $position")
        val list = List(50) { IndexItem(tabIndex + 100) }
        viewBinding.verticalRecycler.adapter = GroupieAdapter().apply {
            addAll(list)
        }
    }

    override fun getLayout(): Int {
        return R.layout.vertical_item
    }

    override fun initializeViewBinding(view: View): VerticalItemBinding {
        return VerticalItemBinding.bind(view)
    }
}