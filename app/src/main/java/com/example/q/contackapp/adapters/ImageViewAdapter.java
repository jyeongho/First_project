package com.example.q.contackapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.q.contackapp.R;

public class ImageViewAdapter extends RecyclerView.Adapter<ImageViewAdapter.ImageViewHolder2> {

    private int[] images;
    private Context mContext;

    public ImageViewAdapter (int[] images, Context context) {
        this.images = images;
        mContext = context;
    }

    @Override
    public ImageViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_gallery, parent,false);
        ImageViewHolder2 imageViewHolder2 = new ImageViewHolder2(view);


        return imageViewHolder2;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder2 imageViewHolder, int i) {

    }


    @Override
    public int getItemCount() {
        return this.images.length;
    }


    public class ImageViewHolder2 extends RecyclerView.ViewHolder //implements View.OnClickListener
    {

        ImageView Album;
        TextView AlbumTitle;


        public ImageViewHolder2 (View itemView) {
            super(itemView);
            Album = itemView.findViewById(R.id.imageView);
            AlbumTitle = itemView.findViewById(R.id.pic_name);
        }
    }
}
