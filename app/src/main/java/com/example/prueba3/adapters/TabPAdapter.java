package com.example.prueba3.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.prueba3.PersonajesFragment;

public class TabPAdapter extends FragmentStatePagerAdapter {

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 : return "PERSONAJE";
            case 1: return  "FRASE";
            case 2: return "IMAGEN";
            default:return null;
        }
    }

    public TabPAdapter(@NonNull FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new PersonajesFragment();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return 1;
    }
}
