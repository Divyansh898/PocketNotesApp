package com.divmtech.pocketnotesapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.divmtech.pocketnotesapp.ui.send.SendFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Logout extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.logout,container,false);
       loadFragment(new SendFragment());
        return root;
    }
    public void loadFragment(Fragment fm)
    {
        FragmentManager f=getFragmentManager();
        FragmentTransaction ft=f.beginTransaction();
        ft.replace(R.id.FrmLogout,fm);
        ft.commit();

    }
}
