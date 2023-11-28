package com.example.runappstor;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.runappstor.Adapter.IteamSuportStoryActivity;
import com.example.runappstor.Adapter.ListStoryAdapter;
import com.example.runappstor.Database.CreateDatabase;
import com.example.runappstor.Entity.ListStory;
import com.example.runappstor.EntityDao.ListStoryDao;

import java.util.List;

public class NovelFragment extends Fragment {

    //lớp xử lý cho tiểu thuyết
    private RecyclerView novelRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate layout for the fragment
        View view = inflater.inflate(R.layout.activity_novel, container, false);
        novelRecyclerView = view.findViewById(R.id.novelRecyclerView);
        novelRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Goi csdl
        CreateDatabase createDatabase = CreateDatabase.getInstance(getContext());
        ListStoryDao listStoryDao = createDatabase.listStoryDao();
        List<ListStory> listStories = listStoryDao.getAllListStories();

        // Thiết lập bố cục cho RecyclerView
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        novelRecyclerView.setLayoutManager(layoutManager);
        IteamSuportStoryActivity itemDecoration = new IteamSuportStoryActivity(getContext());
        novelRecyclerView.addItemDecoration(itemDecoration);
        //goi adapter
        ListStoryAdapter pageListStoryAdapter = new ListStoryAdapter(listStories);
        novelRecyclerView.setAdapter(pageListStoryAdapter);


        // Bắt sự kiện cho ListStoryAdapter

        pageListStoryAdapter.setOnItemClickListener(new ListStoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Xử lý chuyển trang tại đây, dựa trên vị trí (position) của mục được nhấn.
                // Ví dụ:
                Intent intent = new Intent(requireActivity(), InfoStoryActivity.class);
                intent.putExtra("storyValue", listStories.get(position).getCode());
                startActivity(intent);

            }
        });


        return view;
    }


}