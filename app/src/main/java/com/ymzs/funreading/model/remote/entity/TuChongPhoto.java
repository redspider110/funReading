package com.ymzs.funreading.model.remote.entity;

import java.util.List;

/**
 * Created by xumingtao on 2017/9/20.
 */

public class TuChongPhoto {
    private boolean is_history;
    private int counts;
    private List<FeedList> feedList;
    private String message;
    private boolean more;
    private String result;

    public void setIs_history(boolean is_history) {
        this.is_history = is_history;
    }

    public boolean getIs_history() {
        return is_history;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public int getCounts() {
        return counts;
    }

    public void setFeedList(List<FeedList> feedList) {
        this.feedList = feedList;
    }

    public List<FeedList> getFeedList() {
        return feedList;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public boolean getMore() {
        return more;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "TuChongPhoto{" +
                "is_history=" + is_history +
                ", counts=" + counts +
                ", feedList=" + feedList +
                ", message='" + message + '\'' +
                ", more=" + more +
                ", result='" + result + '\'' +
                '}';
    }

    public class Images {

        private int img_id;
        private int user_id;
        private String title;
        private String excerpt;
        private int width;
        private int height;
        private String description;

        public void setImg_id(int img_id) {
            this.img_id = img_id;
        }

        public int getImg_id() {
            return img_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setExcerpt(String excerpt) {
            this.excerpt = excerpt;
        }

        public String getExcerpt() {
            return excerpt;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getWidth() {
            return width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getHeight() {
            return height;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "Images{" +
                    "img_id=" + img_id +
                    ", user_id=" + user_id +
                    ", title='" + title + '\'' +
                    ", excerpt='" + excerpt + '\'' +
                    ", width=" + width +
                    ", height=" + height +
                    ", description='" + description + '\'' +
                    '}';
        }
    }

    public class Title_image {

        private int width;
        private int height;
        private String url;
        public void setWidth(int width) {
            this.width = width;
        }
        public int getWidth() {
            return width;
        }

        public void setHeight(int height) {
            this.height = height;
        }
        public int getHeight() {
            return height;
        }

        public void setUrl(String url) {
            this.url = url;
        }
        public String getUrl() {
            return url;
        }

        @Override
        public String toString() {
            return "Title_image{" +
                    "width=" + width +
                    ", height=" + height +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    public class Verification_list{
        private int verification_type;
        private String verification_reason;

        public int getVerification_type() {
            return verification_type;
        }

        public void setVerification_type(int verification_type) {
            this.verification_type = verification_type;
        }

        public String getVerification_reason() {
            return verification_reason;
        }

        public void setVerification_reason(String verification_reason) {
            this.verification_reason = verification_reason;
        }

        @Override
        public String toString() {
            return "Verification_list{" +
                    "verification_type=" + verification_type +
                    ", verification_reason='" + verification_reason + '\'' +
                    '}';
        }
    }

    public class Site {

        private String site_id;
        private String type;
        private String name;
        private String domain;
        private String description;
        private int followers;
        private String url;
        private String icon;
        private boolean verified;
        private int verified_type;
        private String verified_reason;
        private int verifications;
        private List<Verification_list> verification_list;
        private boolean is_following;

        public void setSite_id(String site_id) {
            this.site_id = site_id;
        }

        public String getSite_id() {
            return site_id;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getDomain() {
            return domain;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setFollowers(int followers) {
            this.followers = followers;
        }

        public int getFollowers() {
            return followers;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getIcon() {
            return icon;
        }

        public void setVerified(boolean verified) {
            this.verified = verified;
        }

        public boolean getVerified() {
            return verified;
        }

        public void setVerified_type(int verified_type) {
            this.verified_type = verified_type;
        }

        public int getVerified_type() {
            return verified_type;
        }

        public void setVerified_reason(String verified_reason) {
            this.verified_reason = verified_reason;
        }

        public String getVerified_reason() {
            return verified_reason;
        }

        public void setVerifications(int verifications) {
            this.verifications = verifications;
        }

        public int getVerifications() {
            return verifications;
        }

        public void setVerification_list(List<Verification_list> verification_list) {
            this.verification_list = verification_list;
        }

        public List<Verification_list> getVerification_list() {
            return verification_list;
        }

        public void setIs_following(boolean is_following) {
            this.is_following = is_following;
        }

        public boolean getIs_following() {
            return is_following;
        }

        @Override
        public String toString() {
            return "Site{" +
                    "site_id='" + site_id + '\'' +
                    ", type='" + type + '\'' +
                    ", name='" + name + '\'' +
                    ", domain='" + domain + '\'' +
                    ", description='" + description + '\'' +
                    ", followers=" + followers +
                    ", url='" + url + '\'' +
                    ", icon='" + icon + '\'' +
                    ", verified=" + verified +
                    ", verified_type=" + verified_type +
                    ", verified_reason='" + verified_reason + '\'' +
                    ", verifications=" + verifications +
                    ", verification_list=" + verification_list +
                    ", is_following=" + is_following +
                    '}';
        }
    }

    public class FeedList {

        private int post_id;
        private String type;
        private String url;
        private String site_id;
        private String author_id;
        private String published_at;
        private String excerpt;
        private int favorites;
        private int comments;
        private boolean rewardable;
        private String parent_comments;
        private String rewards;
        private boolean delete;
        private boolean update;
        private String content;
        private String title;
        private int image_count;
        private List<Images> images;
        private Title_image title_image;
        private List<String> tags;
        private List<String> event_tags;
        private List<String> favorite_list_prefix;
        private List<String> reward_list_prefix;
        private List<String> comment_list_prefix;
        private String data_type;
        private String created_at;
        private List<String> sites;
        private Site site;
        private String recom_type;
        private String rqt_id;
        private boolean is_favorite;

        public void setPost_id(int post_id) {
            this.post_id = post_id;
        }

        public int getPost_id() {
            return post_id;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setSite_id(String site_id) {
            this.site_id = site_id;
        }

        public String getSite_id() {
            return site_id;
        }

        public void setAuthor_id(String author_id) {
            this.author_id = author_id;
        }

        public String getAuthor_id() {
            return author_id;
        }

        public void setPublished_at(String published_at) {
            this.published_at = published_at;
        }

        public String getPublished_at() {
            return published_at;
        }

        public void setExcerpt(String excerpt) {
            this.excerpt = excerpt;
        }

        public String getExcerpt() {
            return excerpt;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public int getFavorites() {
            return favorites;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }

        public int getComments() {
            return comments;
        }

        public void setRewardable(boolean rewardable) {
            this.rewardable = rewardable;
        }

        public boolean getRewardable() {
            return rewardable;
        }

        public void setParent_comments(String parent_comments) {
            this.parent_comments = parent_comments;
        }

        public String getParent_comments() {
            return parent_comments;
        }

        public void setRewards(String rewards) {
            this.rewards = rewards;
        }

        public String getRewards() {
            return rewards;
        }

        public void setDelete(boolean delete) {
            this.delete = delete;
        }

        public boolean getDelete() {
            return delete;
        }

        public void setUpdate(boolean update) {
            this.update = update;
        }

        public boolean getUpdate() {
            return update;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setImage_count(int image_count) {
            this.image_count = image_count;
        }

        public int getImage_count() {
            return image_count;
        }

        public void setImages(List<Images> images) {
            this.images = images;
        }

        public List<Images> getImages() {
            return images;
        }

        public void setTitle_image(Title_image title_image) {
            this.title_image = title_image;
        }

        public Title_image getTitle_image() {
            return title_image;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setEvent_tags(List<String> event_tags) {
            this.event_tags = event_tags;
        }

        public List<String> getEvent_tags() {
            return event_tags;
        }

        public void setFavorite_list_prefix(List<String> favorite_list_prefix) {
            this.favorite_list_prefix = favorite_list_prefix;
        }

        public List<String> getFavorite_list_prefix() {
            return favorite_list_prefix;
        }

        public void setReward_list_prefix(List<String> reward_list_prefix) {
            this.reward_list_prefix = reward_list_prefix;
        }

        public List<String> getReward_list_prefix() {
            return reward_list_prefix;
        }

        public void setComment_list_prefix(List<String> comment_list_prefix) {
            this.comment_list_prefix = comment_list_prefix;
        }

        public List<String> getComment_list_prefix() {
            return comment_list_prefix;
        }

        public void setData_type(String data_type) {
            this.data_type = data_type;
        }

        public String getData_type() {
            return data_type;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setSites(List<String> sites) {
            this.sites = sites;
        }

        public List<String> getSites() {
            return sites;
        }

        public void setSite(Site site) {
            this.site = site;
        }

        public Site getSite() {
            return site;
        }

        public void setRecom_type(String recom_type) {
            this.recom_type = recom_type;
        }

        public String getRecom_type() {
            return recom_type;
        }

        public void setRqt_id(String rqt_id) {
            this.rqt_id = rqt_id;
        }

        public String getRqt_id() {
            return rqt_id;
        }

        public void setIs_favorite(boolean is_favorite) {
            this.is_favorite = is_favorite;
        }

        public boolean getIs_favorite() {
            return is_favorite;
        }

        @Override
        public String toString() {
            return "FeedList{" +
                    "post_id=" + post_id +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", site_id='" + site_id + '\'' +
                    ", author_id='" + author_id + '\'' +
                    ", published_at='" + published_at + '\'' +
                    ", excerpt='" + excerpt + '\'' +
                    ", favorites=" + favorites +
                    ", comments=" + comments +
                    ", rewardable=" + rewardable +
                    ", parent_comments='" + parent_comments + '\'' +
                    ", rewards='" + rewards + '\'' +
                    ", delete=" + delete +
                    ", update=" + update +
                    ", content='" + content + '\'' +
                    ", title='" + title + '\'' +
                    ", image_count=" + image_count +
                    ", images=" + images +
                    ", title_image='" + title_image + '\'' +
                    ", tags=" + tags +
                    ", event_tags=" + event_tags +
                    ", favorite_list_prefix=" + favorite_list_prefix +
                    ", reward_list_prefix=" + reward_list_prefix +
                    ", comment_list_prefix=" + comment_list_prefix +
                    ", data_type='" + data_type + '\'' +
                    ", created_at='" + created_at + '\'' +
                    ", sites=" + sites +
                    ", site=" + site +
                    ", recom_type='" + recom_type + '\'' +
                    ", rqt_id='" + rqt_id + '\'' +
                    ", is_favorite=" + is_favorite +
                    '}';
        }
    }
}
