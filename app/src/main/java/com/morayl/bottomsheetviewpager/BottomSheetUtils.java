package com.morayl.bottomsheetviewpager;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;

public final class BottomSheetUtils {

    public static void setupViewPager(ViewPager2 viewPager) {
        final View bottomSheetParent = findBottomSheetParent(viewPager);
        if (bottomSheetParent != null) {
            viewPager.registerOnPageChangeCallback(new BottomSheetViewPagerListener(viewPager, bottomSheetParent));
        }
    }

    private static class BottomSheetViewPagerListener extends ViewPager2.OnPageChangeCallback {
        private final ViewPager2 viewPager;
        private final BottomSheetBehavior2<View> behavior;

        public BottomSheetViewPagerListener(ViewPager2 viewPager, View bottomSheetParent) {
            this.viewPager = viewPager;
            this.behavior = BottomSheetBehavior2.from(bottomSheetParent);
        }

        @Override
        public void onPageSelected(int position) {
            viewPager.post(behavior::invalidateScrollingChild);
        }
    }

    private static View findBottomSheetParent(final View view) {
        View current = view;
        while (current != null) {
            final ViewGroup.LayoutParams params = current.getLayoutParams();
            if (params instanceof CoordinatorLayout.LayoutParams && ((CoordinatorLayout.LayoutParams) params).getBehavior() instanceof BottomSheetBehavior2) {
                return current;
            }
            final ViewParent parent = current.getParent();
            current = !(parent instanceof View) ? null : (View) parent;
        }
        return null;
    }

}