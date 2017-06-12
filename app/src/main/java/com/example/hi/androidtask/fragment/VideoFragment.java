package com.example.hi.androidtask.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hi.androidtask.R;
import com.example.hi.androidtask.adapter.VideoRecyclerAdapter;
import com.example.hi.androidtask.model.Video;

import java.util.ArrayList;

/**
 * Created by hi on 6/12/2017.
 */

public class VideoFragment extends Fragment {

    RecyclerView recyclerView;
    VideoRecyclerAdapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Video> videoList;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.videofragment_layout, null);
        recyclerView = (RecyclerView)view.findViewById(R.id.videorecycler);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter = new VideoRecyclerAdapter(getData(), getActivity());
        recyclerView.setAdapter(mAdapter);
    }

    private ArrayList<Video> getData()
    {
        videoList = new ArrayList<>();

        Video videoItem = new Video();
        videoItem.setImage(R.drawable.slide1);
        videoItem.setName("EMPTINESS FT. JUSTIN TIBELKAR");
        videoItem.setDescription("Lorem Ipsum is simple dummy text of the printing and type setting industry");
        videoItem.setTime("18 HOURS AGO");
        videoList.add(videoItem);

        videoItem = new Video();
        videoItem.setImage(R.drawable.slide2);
        videoItem.setName("I'AM FALLING LOVE WITH YOU");
        videoItem.setDescription("Lorem Ipsum is simple dummy text of the printing and type setting industry");
        videoItem.setTime("20 HOURS AGO");
        videoList.add(videoItem);

        videoItem = new Video();
        videoItem.setImage(R.drawable.slide3);
        videoItem.setName("BABY FT. JUSTIN BABER");
        videoItem.setDescription("Lorem Ipsum is simple dummy text of the printing and type setting industry");
        videoItem.setTime("22 HOURS AGO");
        videoList.add(videoItem);

        return videoList;
    }
}
