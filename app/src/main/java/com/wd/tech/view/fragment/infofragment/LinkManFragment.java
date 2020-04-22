package com.wd.tech.view.fragment.infofragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wd.tech.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LinkManFragment extends Fragment {

    public LinkManFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_link_man, container, false);
    }
}
