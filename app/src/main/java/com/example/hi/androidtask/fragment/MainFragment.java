package com.example.hi.androidtask.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hi.androidtask.R;
import com.example.hi.androidtask.adapter.TabSectionAdapter;
import com.example.hi.androidtask.adapter.ViewPagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hi on 6/12/2017.
 */

public class MainFragment extends Fragment {

    ViewPager viewPager, viewPager1;
    LinearLayout sliderDots;
    private int dotsCount;
    private ImageView[] dots;
    private TabLayout tabLayout;
    TabSectionAdapter tabAdapter;
    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.main_fragment_layout, container, false);
        initView();
        createViewPager(viewPager1);  //adding tab fragments to viewpager
        tabLayout.setupWithViewPager(viewPager1);
        createTabIcons();
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());  //adapter for automatic sliding images
        viewPager.setAdapter(viewPagerAdapter);

        // To display dot indicator
        dotsCount = viewPagerAdapter.getCount();
        dots = new ImageView[dotsCount];

        for(int i=0; i<dotsCount; i++)
        {
            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.non_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            params.setMargins(8, 0, 8, 0);
            sliderDots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i=0; i<dotsCount; i++)
                {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000 );

        return v;
    }

    private void initView()
    {
        viewPager = (ViewPager)v.findViewById(R.id.viewpager);
        viewPager1 = (ViewPager)v.findViewById(R.id.container);
        sliderDots = (LinearLayout)v.findViewById(R.id.sliderdots);
        tabLayout = (TabLayout)v.findViewById(R.id.tab);
    }

    private void createViewPager(ViewPager viewPager) {
        TabSectionAdapter adapter = new TabSectionAdapter(getActivity().getSupportFragmentManager());
        adapter.addFrag(new VideoFragment(), "Tab 1");
        adapter.addFrag(new ImageFragment(), "Tab 2");
        adapter.addFrag(new MilestoneFragment(), "Tab 3");
        viewPager.setAdapter(adapter);
    }

    private void createTabIcons()
    {
        TextView tabOne = (TextView)LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabOne.setText("Videos");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_video, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView)LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Images");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_image, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView)LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabThree.setText("Milestones");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_milestone, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }

    public class MyTimerTask extends TimerTask
    {

        @Override
        public void run() {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem() == 0)
                    {
                        viewPager.setCurrentItem(1);
                    }
                    else if(viewPager.getCurrentItem() == 1)
                    {
                        viewPager.setCurrentItem(2);
                    }
                    else
                    {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
