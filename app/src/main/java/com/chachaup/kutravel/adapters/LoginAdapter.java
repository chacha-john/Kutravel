package com.chachaup.kutravel.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.chachaup.kutravel.ui.SignInFragment;
import com.chachaup.kutravel.ui.CreateAccount;

public class LoginAdapter extends FragmentPagerAdapter {

    int tabs;

    public LoginAdapter(FragmentManager fm, int tabs){
        super(fm);
        this.tabs = tabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new SignInFragment();
            case 1:
                return new CreateAccount();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}
