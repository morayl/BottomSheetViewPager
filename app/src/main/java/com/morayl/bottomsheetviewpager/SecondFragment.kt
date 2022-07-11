package com.morayl.bottomsheetviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayoutMediator
import com.morayl.bottomsheetviewpager.databinding.FragmentSecondBinding
import com.morayl.footprintktx.footprint

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomSheet = binding.secondBottomSheet.layoutParams as? CoordinatorLayout.LayoutParams
        footprint(bottomSheet)
        val behavior = bottomSheet?.behavior as? ViewPager2BottomSheetBehavior<View>
        footprint(behavior)
        behavior?.isFitToContents = false
        behavior?.halfExpandedRatio = 0.7f

        setup()
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    private fun setup() {
        val vp = SecondPagerAdapter(this, 4)
        binding.secondViewPager.adapter = vp
        TabLayoutMediator(binding.secondTab, binding.secondViewPager) { tab, position ->
            tab.text = "tab$position"
        }.attach()
        val bottomSheet = binding.secondBottomSheet.layoutParams as? CoordinatorLayout.LayoutParams
        footprint(bottomSheet)
        val behavior = bottomSheet?.behavior as? ViewPager2BottomSheetBehavior<View>
        footprint(behavior)
        behavior?.isFitToContents = false
        behavior?.halfExpandedRatio = 0.7f
        behavior?.state = BottomSheetBehavior.STATE_HALF_EXPANDED
        BottomSheetUtils.setupViewPager(binding.secondViewPager)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private class SecondPagerAdapter(fragment: Fragment, private val size: Int) : FragmentStateAdapter(fragment) {
        override fun createFragment(position: Int): Fragment {
            return ContentFragment.newInstance(position)
        }

        override fun getItemCount(): Int {
            return size
        }
    }
}