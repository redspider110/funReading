package com.ymzs.funreading.view.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.common.base.Strings;
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

        String title = photo.getTitle();
        if(Strings.isNullOrEmpty(title)){
            holder.mImgTitle.setVisibility(View.GONE);
        }else {
            holder.mTvTitle.setText(title);
            holder.mImgTitle.setVisibility(View.VISIBLE);
        }

        //holder.mImgTitle.setImageURI(photo.getTitleImageUrl());
        Glide.with(mContext)
                .load(photo.getTitleImageUrl())
                //.centerCrop()
                //.fitCenter()
                .placeholder(R.drawable.logo)
                .into(holder.mImgTitle);
        holder.mTvAuthor.setText(photo.getAuthor());
        //holder.mImgAuthorIcon.setImageURI(photo.getAuthorIconUrl());
        Glide.with(mContext)
                .load(photo.getAuthorIconUrl())
                .into(holder.mImgAuthorIcon);
        holder.mTvTag.setText(photo.getTag());
        String content = photo.getContent();
        if(Strings.isNullOrEmpty(content)){
            holder.mTvContent.setVisibility(View.GONE);
        }else {
            holder.mTvContent.setText(content);
            holder.mTvContent.setVisibility(View.VISIBLE);
        }
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
        TextView mTvTag;
        TextView mTvContent;

        public PhotoListViewHolder(View itemView) {
            super(itemView);
            mTvTitle = (TextView) itemView.findViewById(R.id.photo_list_item_tv_title);
            mImgTitle = (ImageView) itemView.findViewById(R.id.photo_list_item_img_title);
            mTvAuthor = (TextView) itemView.findViewById(R.id.photo_list_item_tv_author);
            mImgAuthorIcon = (ImageView) itemView.findViewById(R.id.photo_item_list_img_author);
            mTvTag = (TextView) itemView.findViewById(R.id.photo_list_item_tv_tag);
            mTvContent = (TextView) itemView.findViewById(R.id.photo_list_item_tv_content);
        }
    }

    /**
     * ItemDecoration that draws an divider between items in a RecyclerView.
     */
    public static class DividerItemDecoration extends RecyclerView.ItemDecoration {

        private Drawable mDivider;

        public DividerItemDecoration(Context context) {
            mDivider = context.getDrawable(R.drawable.divider);
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();
            for (int i = 0; i < parent.getChildCount(); i++) {
                View child = parent.getChildAt(i);
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }
    }

}
