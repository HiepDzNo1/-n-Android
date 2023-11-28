package com.example.runappstor;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.runappstor.Adapter.ListStoryAdapter;
import com.example.runappstor.Adapter.PageListStory;
import com.example.runappstor.Database.CreateDatabase;
import com.example.runappstor.Entity.ListStory;
import com.example.runappstor.Entity.User;
import com.example.runappstor.EntityDao.UserDao;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class InterfaceActivity extends AppCompatActivity {

    // Giao diện chính
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    private PageListStory pageListStory;
    private ImageButton image_buttonAvatar;
    private CreateDatabase createDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
        image_buttonAvatar = findViewById(R.id.image_buttonAvatar);
        pageListStory = new PageListStory(this);
        viewPager2.setAdapter(pageListStory);
        int idUser = getIntent().getIntExtra("userId",-1);

        createDatabase = CreateDatabase.getInstance(this);

        UserDao user = createDatabase.userDao();
        Cursor cursor = user.getImageByIdUser(idUser);
        if (cursor != null && cursor.moveToFirst()) {
            // Lấy chỉ số cột của Chapter
            // Lấy chỉ số cột của Chapter
            int avatarIndex = cursor.getColumnIndex("Avatar");

            // Lấy giá trị Chapter từ Cursor
            String avatar = cursor.getString(avatarIndex);


            // TODO: Xử lý tải lên hình ảnh avatar từ selectedImageUri
            ImageButton imageViewAvatar = findViewById(R.id.image_buttonAvatar);

            RequestOptions requestOptions = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.NONE);

            Glide.with(InterfaceActivity.this)
                    .load(avatar)
                    .apply(requestOptions)
                    .into(imageViewAvatar);
        }

        // Kết nối TabLayout với ViewPager2
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            // Thiết lập tiêu đề cho mỗi tab
            if (position == 0) {
                tab.setText("Tiểu Thuyết");
            } else if (position == 1) {
                tab.setText("Truyện Tranh");
            }
        }).attach();

    }
}