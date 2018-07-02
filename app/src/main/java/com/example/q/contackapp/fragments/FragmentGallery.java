package com.example.q.contackapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.q.contackapp.R;
import com.example.q.contackapp.adapters.ContactsRvAdapter;
import com.example.q.contackapp.adapters.RecyclerPicAdapter;

public class FragmentGallery extends Fragment {

    private View v;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private int[] images = {R.drawable.pic1};

    public FragmentGallery() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frag_gallery, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);

        layoutManager = new GridLayoutManager(getContext(), 2);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(layoutManager);
        //now adapter

        RecyclerPicAdapter adapter = new RecyclerPicAdapter(images);

        recyclerView.setAdapter(adapter);

        return v;
    }

}

