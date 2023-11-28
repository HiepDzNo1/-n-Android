package com.example.runappstor.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.runappstor.ChapterFragment;
import com.example.runappstor.DetailFragment;


public class PageStory extends FragmentStateAdapter {
    private static final int NUM_ITEMS = 2;

    //xử lý phân trang
    public PageStory(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {

            case 0:
                return new DetailFragment();
            case 1:
                return new ChapterFragment();

            default:
                throw new IllegalArgumentException("Invalid position: " + position);
        }

    }
    @Override public int getItemCount() {

        return NUM_ITEMS;
    }
}

