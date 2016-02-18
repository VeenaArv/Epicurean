package com.example.arvind.epicurean;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by arvind on 2/15/16.
 */
public class Epicurean_PagerAdapter extends FragmentPagerAdapter {
    public Epicurean_PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    // number of tabs
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        // first tab is the home tab. Displays that fragment
        if (position == 0) {
            return new LatestRecipe();
        }
        else
            return new InputData();
    }
}
