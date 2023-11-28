package com.example.runappstor.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.runappstor.Entity.Story;
import com.example.runappstor.R;

import java.util.List;

public class PageChapter extends RecyclerView.Adapter<PageChapter.ChapterViewHolder> {
    private List<Story> chapterList;
    private OnItemClickListener listener;

    public PageChapter(List<Story> chapters, OnItemClickListener listener) {
        this.chapterList = chapters;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ChapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chapter, parent, false);
        return new ChapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterViewHolder holder, int position) {
        if (position >= 0 && position < chapterList.size()) {
            Story story = chapterList.get(position);
            holder.bind(story);
        }
    }

    @Override
    public int getItemCount() {
        return chapterList.size();
    }

    public class ChapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textViewChapterNumber;
        private TextView textViewChapterTitle;

        public ChapterViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewChapterNumber = itemView.findViewById(R.id.textViewChapterNumber);
            textViewChapterTitle = itemView.findViewById(R.id.textViewChapterTitle);

            // Đăng ký trình nghe sự kiện OnClickListener
            itemView.setOnClickListener(this);
        }

        public void bind(Story story) {
            textViewChapterNumber.setText(String.valueOf(story.getChapter()));
            textViewChapterTitle.setText(story.getNameChapter());
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Story clickedStory = chapterList.get(position);
                listener.onItemClick(clickedStory.getChapter());
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}