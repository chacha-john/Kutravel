package com.chachaup.kutravel.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.chachaup.kutravel.model.events.Event;
import com.chachaup.kutravel.ui.EventDetailFragment;

import java.util.List;

public class EventPagerAdapter extends FragmentPagerAdapter {
    private List<Event> mEvents;

    public EventPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Event> events){
        super(fm,behavior);
        mEvents = events;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return EventDetailFragment.newInstance(mEvents.get(position));
    }

    @Override
    public int getCount() {
        return mEvents.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
