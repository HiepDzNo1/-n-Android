package com.example.runappstor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.runappstor.Adapter.ListStoryAdapter;
import com.example.runappstor.Adapter.PageChapter;
import com.example.runappstor.Database.CreateDatabase;
import com.example.runappstor.Entity.Story;
import com.example.runappstor.EntityDao.StoryDao;

import java.util.List;

public class ChapterFragment extends Fragment {
    private RecyclerView chapterRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate layout for the fragment
        View view = inflater.inflate(R.layout.activity_chapter, container, false);
        chapterRecyclerView = view.findViewById(R.id.chapterRecyclerView);
        chapterRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // Lấy giá trị storyValue từ Intent
        String storyCode = requireActivity().getIntent().getStringExtra("storyValue");

        // Goi csdl
        CreateDatabase createDatabase = CreateDatabase.getInstance(getContext());
        StoryDao storyDao = createDatabase.storyDao();
        // Lọc danh sách theo mã
        List<Story> listChapter = storyDao.getListChapterStoryByCode(storyCode);

        // Bắt sự kiện cho ListStoryAdapter

        PageChapter pageChapterAdapter = new PageChapter(listChapter, new PageChapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(requireActivity(), ReadStoryActivity.class);
                intent.putExtra("chapterValue", listChapter.get(position).getChapter());
                intent.putExtra("storyValue", storyCode);
                startActivity(intent);


            }

        });
        chapterRecyclerView.setAdapter(pageChapterAdapter);

        return view;

        }

    }