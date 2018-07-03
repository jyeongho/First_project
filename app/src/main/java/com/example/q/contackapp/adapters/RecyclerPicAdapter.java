package com.example.q.contackapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.q.contackapp.MainActivity;
import com.example.q.contackapp.PictureActivity;
import com.example.q.contackapp.R;
import com.example.q.contackapp.fragments.FragmentContactsCall;
import com.example.q.contackapp.fragments.FragmentPicture;

public class RecyclerPicAdapter extends RecyclerView.Adapter<RecyclerPicAdapter.ImageViewHolder> {

    private int[] images;
    private Context mContext;

    public RecyclerPicAdapter (int[] images, Context context) {
        this.images = images;
        mContext = context;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_layout, parent,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);


        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        int image_id = this.images[position];
        holder.Album.setImageResource(image_id);
        holder.AlbumTitle.setText("Image :" + position);

//        holder.Album.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(mContext, PictureActivity.class);
//                Intent image_url = intent.putExtra("image_url", images[position]);
//                mContext.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return this.images.length;
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        ImageView Album;
        TextView AlbumTitle;


        public ImageViewHolder(View itemView) {
            super(itemView);
            Album = itemView.findViewById(R.id.album);
            AlbumTitle = itemView.findViewById(R.id.album_title);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Fragment fragment = new FragmentPicture();
            FragmentManager fragmentManager = ((MainActivity)mContext).getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frag_gallery, fragment).commit();
        }
    }
}
