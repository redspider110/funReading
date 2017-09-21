package com.ymzs.funreading.model.remote.adapter;

import com.google.common.base.Strings;
import com.ymzs.funreading.model.Photo;
import com.ymzs.funreading.model.remote.entity.TuChongPhoto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xumingtao on 2017/9/20.
 */

public class TuChongPhotoAdapter implements PhotoAdapter {

    public TuChongPhoto mTuChongPhoto;

    public TuChongPhotoAdapter(TuChongPhoto photo){
        mTuChongPhoto = photo;
    }

    @Override
    public List<Photo> getPhotos() {
        List<Photo> photos = new ArrayList<Photo>();
        List<TuChongPhoto.FeedList> lists = mTuChongPhoto.getFeedList();
        for(TuChongPhoto.FeedList feedList : lists){
            Photo photo = new Photo();
            photo.setTime(feedList.getPublished_at());
            photo.setTitle(feedList.getTitle());
            photo.setTitleImageUrl(getTitleImageUrl(feedList));
            photo.setAuthor(feedList.getSite().getName());
            photo.setAuthorIconUrl(feedList.getSite().getIcon());
            photos.add(photo);
        }
        return photos;
    }

    private String getTitleImageUrl(TuChongPhoto.FeedList feedList){
        String url = null;
        TuChongPhoto.Title_image title_image = feedList.getTitle_image();
        if(title_image == null){
            List<TuChongPhoto.Images> imagesList = feedList.getImages();
            TuChongPhoto.Images images = imagesList.get(0);
            // https://photo.tuchong.com/875829/f/10850281.jpg
            url = "https://photo.tuchong.com/" + images.getUser_id() + "/f/" + images.getImg_id() + ".jpg";
        }else{
            url = title_image.getUrl();
        }
        return url;
    }
}
