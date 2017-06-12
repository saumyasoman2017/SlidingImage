package com.example.hi.androidtask.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hi.androidtask.R;
import com.example.hi.androidtask.model.Video;

import java.util.ArrayList;

/**
 * Created by hi on 6/12/2017.
 */

public class VideoRecyclerAdapter extends RecyclerView.Adapter<VideoRecyclerAdapter.ViewHolder> {

    ArrayList<Video> videoItems = new ArrayList<>();
    Context context;

    public VideoRecyclerAdapter(ArrayList<Video> videoItems, Context context) {
        this.videoItems = videoItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_recycler_custom_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        try
        {
            Video item = videoItems.get(position);
            holder.videoName.setText(item.getName());
            holder.imageView.setImageResource(item.getImage());
            holder.description.setText(item.getDescription());
            holder.time.setText(item.getTime());
        }
        catch (Exception e)
        {

        }
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView videoName, time, description;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView)itemView.findViewById(R.id.video_thumbnail);
            videoName = (TextView)itemView.findViewById(R.id.videoname);
            time = (TextView)itemView.findViewById(R.id.timetext);
            description = (TextView)itemView.findViewById(R.id.videodescription);
        }
    }
}
