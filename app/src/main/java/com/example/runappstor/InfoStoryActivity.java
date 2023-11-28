package com.example.runappstor;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.runappstor.Adapter.PageStory;
import com.example.runappstor.Database.CreateDatabase;
import com.example.runappstor.Entity.ListStory;
import com.example.runappstor.EntityDao.ListStoryDao;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

public class InfoStoryActivity extends AppCompatActivity {

    //giao diện chính
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    private PageStory pageStory;
    private TextView textViewNameStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_story);

        //xử lý phân trang
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
        pageStory = new PageStory(this);
        viewPager2.setAdapter(pageStory);


        // Kết nối TabLayout với ViewPager2
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            // Thiết lập tiêu đề cho mỗi tab
            if (position == 0) {
                tab.setText("Chi tiết");
            } else if (position == 1) {
                tab.setText("Chương");
            }
        }).attach();

        loadNameStory();
        loadImageAvatarStory();

    }
    private void loadNameStory() {
        // lấy mã code từ Intent:
        String storyCode = getIntent().getStringExtra("storyValue");
        CreateDatabase db = CreateDatabase.getInstance(this);
        ListStoryDao listStoryDao = db.listStoryDao();
        String storyName = listStoryDao.getNameStory(storyCode);
        textViewNameStory = findViewById(R.id.textViewNameStory);
        textViewNameStory.setText(storyName);

    }
    private void loadImageAvatarStory() {
        String storyCode = getIntent().getStringExtra("storyValue");
        CreateDatabase db = CreateDatabase.getInstance(this);
        ListStoryDao listStoryDao = db.listStoryDao();
        String ImageUrl = listStoryDao.getImageUrlByCode(storyCode);
        ImageView imageView = findViewById(R.id.imageViewStory); // Thay thế bằng ID của ImageView trong layout của bạn

        Glide.with(this)
                .load(ImageUrl)
                .apply(new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true))
                .into(imageView);

    }

}

