package com.example.q.contackapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.q.contackapp.R;
import com.example.q.contackapp.adapters.RecyclerPicAdapter;

public class FragmentPicture extends Fragment {
    private View v;


    public FragmentPicture() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        int image_id = getArguments().getInt("image_id");
        String pic_name = getArguments().getString("pic_name");
        v = inflater.inflate(R.layout.activity_gallery, container, false);

        ImageView image = v.findViewById(R.id.imageView);
        TextView name = v.findViewById(R.id.pic_name);

        image.setImageResource(image_id);
        name.setText(pic_name);




     /*   recyclerView = v.findViewById(R.id.recyclerView);

        ImageViewAdapter adapter = new ImageViewAdapter(images, getContext());

        recyclerView.setAdapter(adapter);
*/
        return v;
    }
}
