package com.example.runappstor.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.runappstor.Entity.ListStory;
import com.example.runappstor.R;

import java.util.List;

public class ListStoryAdapter extends RecyclerView.Adapter<ListStoryAdapter.ViewHolder> {
    private List<ListStory> listStories;
    private OnItemClickListener onItemClickListener;

    public ListStoryAdapter(List<ListStory> listStories) {
        this.listStories = listStories;
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_name_story1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListStory listStory = listStories.get(position);
        String imageUrl = listStory.getAvatarStory();

        RequestOptions requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.NONE);

        Glide.with(holder.itemView.getContext())
                .load(imageUrl)
                .apply(requestOptions)
                .into(holder.avatarStoryImageButton);
        holder.TextViewNameStory.setText(listStory.getNameStory());
    }

    @Override
    public int getItemCount() {
        return listStories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageButton avatarStoryImageButton;
        public TextView TextViewNameStory;
        public ViewHolder(View itemView) {
            super(itemView);
            avatarStoryImageButton = itemView.findViewById(R.id.avatarStoryImageButton);
            TextViewNameStory = itemView.findViewById(R.id.TextViewNameStory);


            avatarStoryImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        int position = getAbsoluteAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            onItemClickListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}