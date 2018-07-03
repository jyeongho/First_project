package com.example.q.contackapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.q.contackapp.R;
import com.example.q.contackapp.adapters.ImageViewAdapter;
import com.example.q.contackapp.adapters.RecyclerPicAdapter;

public class FragmentPicture extends Fragment {
    private View v;
    private RecyclerView recyclerView;
    private int[] images = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
            R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9
            , R.drawable.pic10, R.drawable.pic11, R.drawable.pic12, R.drawable.pic13};

    public FragmentPicture() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.activity_gallery, container, false);
     /*   recyclerView = v.findViewById(R.id.recyclerView);

        ImageViewAdapter adapter = new ImageViewAdapter(images, getContext());

        recyclerView.setAdapter(adapter);
*/
        return v;
    }
}
