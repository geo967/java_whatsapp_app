package com.example.mywhatsapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mywhatsapp.fragments.Chats;
import com.example.mywhatsapp.fragments.BlankFragment2;
import com.example.mywhatsapp.fragments.BlankFragment3;

public class PagerAdapter extends FragmentStateAdapter {


    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new BlankFragment3();
            case 2:
                return new BlankFragment2();
            default:
                return new Chats();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
