package com.example.runappstor;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.runappstor.Database.CreateDatabase;
import com.example.runappstor.EntityDao.ListStoryDao;
import com.example.runappstor.EntityDao.StoryDao;

public class ReadStoryActivity extends AppCompatActivity {
    private TextView textViewChapterNumber, TextViewChapterTitle,TextViewChapterContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_story);
        // Tạo một đối tượng CreateDatabase từ cơ sở dữ liệu Room

        loadChapterStory();
        loadNameChapterStory();
        loadContentStory();
    }
    private void loadChapterStory() {
        // Lấy mã code và số chương từ Intent
        String storyValue = getIntent().getStringExtra("storyValue");
        int chapterValue = getIntent().getIntExtra("chapterValue",-1);

        // Lấy instance của database
        CreateDatabase db = CreateDatabase.getInstance(this);

        // Lấy DAO tương ứng
        StoryDao storyDao = db.storyDao();

        // Truy vấn thông tin chương truyện và nhận Cursor
        Cursor cursor = storyDao.getContentByCode(storyValue,chapterValue);

        // Kiểm tra và xử lý Cursor
        if (cursor != null && cursor.moveToFirst()) {
            // Lấy chỉ số cột của Chapter
            // Lấy chỉ số cột của Chapter
            int chapterIndex = cursor.getColumnIndex("Chapter");

            // Lấy giá trị Chapter từ Cursor
            String chapter = cursor.getString(chapterIndex);

            // Hiển thị thông tin chương truyện
            textViewChapterNumber = findViewById(R.id.textViewChapterNumber);
            textViewChapterNumber.setText(chapter);

            // Đóng Cursor sau khi sử dụng// Đóng Cursor sau khi sử dụng
            cursor.close();
        }
    }
    private void loadNameChapterStory() {
    // lấy mã code từ Intent:
    String storyValue = getIntent().getStringExtra("storyValue");
    int chapterValue = getIntent().getIntExtra("chapterValue",-1);

    // Lấy instance của database
    CreateDatabase db = CreateDatabase.getInstance(this);

    // Lấy DAO tương ứng
    StoryDao storyDao = db.storyDao();

    // Truy vấn thông tin chương truyện và nhận Cursor
    Cursor cursor = storyDao.getContentByCode(storyValue,chapterValue);

    // Kiểm tra và xử lý Cursor
        if (cursor != null && cursor.moveToFirst()) {
        // Lấy chỉ số cột của Chapter
        int nameChapterIndex = cursor.getColumnIndex("Name_Chapter");

        // Lấy giá trị Chapter từ Cursor
        String nameChapter = cursor.getString(nameChapterIndex);

        // Hiển thị thông tin chương truyện
        TextViewChapterTitle = findViewById(R.id.textViewChapterTitle);
        TextViewChapterTitle.setText(nameChapter);

        // Đóng Cursor sau khi sử dụng
        cursor.close();
    }
    }
    private void loadContentStory() {
        // lấy mã code từ Intent:
        String storyValue = getIntent().getStringExtra("storyValue");
        int chapterValue = getIntent().getIntExtra("chapterValue",-1);

        // Lấy instance của database
        CreateDatabase db = CreateDatabase.getInstance(this);

        // Lấy DAO tương ứng
        StoryDao storyDao = db.storyDao();

        // Truy vấn thông tin chương truyện và nhận Cursor
        Cursor cursor = storyDao.getContentByCode(storyValue,chapterValue);

        // Kiểm tra và xử lý Cursor
        if (cursor != null && cursor.moveToFirst()) {
            // Lấy chỉ số cột của Chapter
            int contentIndex = cursor.getColumnIndex("Content");

            // Lấy giá trị Chapter từ Cursor
            String content = cursor.getString(contentIndex);

            // Hiển thị thông tin chương truyện
            TextViewChapterContent = findViewById(R.id.textViewChapterContent);
            TextViewChapterContent.setText(content);

            // Đóng Cursor sau khi sử dụng
            cursor.close();
        }
    }
}
