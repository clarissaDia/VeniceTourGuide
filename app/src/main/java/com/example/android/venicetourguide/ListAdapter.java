package com.example.android.venicetourguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ListAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public ListAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new PlacesFragment();
        } else if (position ==1){
            return new MuseumsFragment();
        } else if (position == 2) {
            return new EventsFragment();
        }
        else {
            return new WordsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return mContext.getString(R.string.visit_list);
        }
        else if (position == 1){
            return mContext.getString(R.string.museums_visit);
        }
        else if (position == 2){
            return mContext.getString(R.string.events);
        }
        else {
            return mContext.getString(R.string.words);
        }
    }
}

