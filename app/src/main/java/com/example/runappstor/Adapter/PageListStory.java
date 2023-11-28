package com.example.runappstor.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.runappstor.ComicFragment;
import com.example.runappstor.NovelFragment;

public class PageListStory extends FragmentStateAdapter {
    private static final int NUM_ITEMS = 2;

    //xử lý phân trang
    public PageListStory(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {

            case 0:
                return new NovelFragment();
            case 1:
                return new ComicFragment();

            default:
                throw new IllegalArgumentException("Invalid position: " + position);
        }

    }
    @Override public int getItemCount() {

        return NUM_ITEMS;
    }
}

