package com.ymzs.funreading.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ymzs.funreading.R;
import com.ymzs.funreading.model.Photo;

import java.util.List;

/**
 * Created by xumingtao on 2017/9/20.
 */

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.PhotoListViewHolder>{

    private Context mContext;
    private List<Photo> mPhotoList;

    public PhotoListAdapter(Context context){
        mContext = context;
    }

    public void setData(List<Photo> photos){
        mPhotoList = photos;
        notifyDataSetChanged();
    }

    @Override
    public PhotoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        PhotoListViewHolder holder = new PhotoListViewHolder(layoutInflater.inflate(R.layout.photo_list_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(PhotoListViewHolder holder, int position) {
        Photo photo = mPhotoList.get(position);
        holder.mTvTitle.setText(photo.getTitle());
        //holder.mImgTitle.setImageURI(photo.getTitleImageUrl());
        Glide.with(mContext)
                .load(photo.getTitleImageUrl())
                //.centerCrop()
                //.fitCenter()
                .into(holder.mImgTitle);
        holder.mTvAuthor.setText(photo.getAuthor());
        //holder.mImgAuthorIcon.setImageURI(photo.getAuthorIconUrl());
        Glide.with(mContext)
                .load(photo.getAuthorIconUrl())
                .into(holder.mImgAuthorIcon);
    }

    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }

    class PhotoListViewHolder extends RecyclerView.ViewHolder{
        TextView mTvTitle;
        ImageView mImgTitle;
        TextView mTvAuthor;
        ImageView mImgAuthorIcon;

        public PhotoListViewHolder(View itemView) {
            super(itemView);
            mTvTitle = (TextView) itemView.findViewById(R.id.photo_list_item_tv_title);
            mImgTitle = (ImageView) itemView.findViewById(R.id.photo_list_item_img_title);
            mTvAuthor = (TextView) itemView.findViewById(R.id.photo_list_item_tv_author);
            mImgAuthorIcon = (ImageView) itemView.findViewById(R.id.photo_item_list_img_author);
        }
    }
}
