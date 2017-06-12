package com.example.hi.androidtask.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hi.androidtask.R;

/**
 * Created by hi on 6/12/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {
    Context context;
    ImageView imageView;
    LayoutInflater layoutInflater;
    private Integer[] images = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};



    public ViewPagerAdapter(Context context)
    {
        this.context = context;

    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_image_layout, null);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView2);
        imageView.setImageResource(images[position]);
        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
