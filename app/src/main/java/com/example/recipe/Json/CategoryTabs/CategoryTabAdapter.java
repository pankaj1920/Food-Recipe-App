package com.example.recipe.Json.CategoryTabs;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class CategoryTabAdapter extends FragmentStatePagerAdapter {
    List<String> tabTitle;
    List<Fragment> tabFragments;

    public CategoryTabAdapter(FragmentManager fm, List<String> tabTitle, List<Fragment> tabFragments) {
        super(fm);
        this.tabTitle = tabTitle;
        this.tabFragments = tabFragments;
    }

    @Override
    public Fragment getItem(int i) {
        return tabFragments.get(i);
    }

    @Override
    public int getCount() {
        return tabTitle.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle.get(position);
    }
}
