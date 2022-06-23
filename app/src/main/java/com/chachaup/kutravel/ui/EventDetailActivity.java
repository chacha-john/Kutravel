package com.chachaup.kutravel.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.chachaup.kutravel.R;
import com.chachaup.kutravel.adapters.EventPagerAdapter;
import com.chachaup.kutravel.model.events.Event;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventDetailActivity extends AppCompatActivity {
    List<Event> mEvents;
    private EventPagerAdapter mAdapter;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        ButterKnife.bind(this);

        mEvents = Parcels.unwrap(getIntent().getParcelableExtra("events"));
        int startingPosition = getIntent().getIntExtra("position",0);

        mAdapter = new EventPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mEvents);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(startingPosition);

    }
}