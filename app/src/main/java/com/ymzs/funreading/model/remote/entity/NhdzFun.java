package com.ymzs.funreading.model.remote.entity;

import java.util.List;

/**
 * Created by xumingtao on 2017/8/29.
 */

public class NhdzFun {

    private String message;
    private DataX data;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setData(DataX data) {
        this.data = data;
    }

    public DataX getData() {
        return data;
    }

    @Override
    public String toString() {
        return "NhdzFun{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public class DataX {

        private boolean has_more;
        private String tip;
        private boolean has_new_message;
        private float max_time;
        private float min_time;
        private List<Data> data;

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public boolean getHas_more() {
            return has_more;
        }

        public void setTip(String tip) {
            this.tip = tip;
        }

        public String getTip() {
            return tip;
        }

        public void setHas_new_message(boolean has_new_message) {
            this.has_new_message = has_new_message;
        }

        public boolean getHas_new_message() {
            return has_new_message;
        }

        public void setMax_time(float max_time) {
            this.max_time = max_time;
        }

        public float getMax_time() {
            return max_time;
        }

        public void setMin_time(float min_time) {
            this.min_time = min_time;
        }

        public float getMin_time() {
            return min_time;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }

        public List<Data> getData() {
            return data;
        }

        @Override
        public String toString() {
            return "DataX{" +
                    "has_more=" + has_more +
                    ", tip='" + tip + '\'' +
                    ", has_new_message=" + has_new_message +
                    ", max_time=" + max_time +
                    ", min_time=" + min_time +
                    ", data=" + data +
                    '}';
        }

        public class Data {

            private Group group;
//            private List<String> comments;
            private int type;
            private float display_time;
            private float online_time;

            public void setGroup(Group group) {
                this.group = group;
            }

            public Group getGroup() {
                return group;
            }

//            public void setComments(List<String> comments) {
//                this.comments = comments;
//            }
//
//            public List<String> getComments() {
//                return comments;
//            }

            public void setType(int type) {
                this.type = type;
            }

            public int getType() {
                return type;
            }

            public void setDisplay_time(float display_time) {
                this.display_time = display_time;
            }

            public float getDisplay_time() {
                return display_time;
            }

            public void setOnline_time(float online_time) {
                this.online_time = online_time;
            }

            public float getOnline_time() {
                return online_time;
            }

            @Override
            public String toString() {
                return "Data{" +
                        "group=" + group +
//                        ", comments=" + comments +
                        ", type=" + type +
                        ", display_time=" + display_time +
                        ", online_time=" + online_time +
                        '}';
            }

            public class Group {

                private String text;
                private List<Dislike_reason> dislike_reason;
                private float create_time;
                private long id;
                private int favorite_count;
                private int go_detail_count;
                private int user_favorite;
                private int share_type;
                private User user;
                private int is_can_share;
                private int category_type;
                private String share_url;
                private int label;
                private String content;
                private int comment_count;
                private String id_str;
                private int media_type;
                private int share_count;
                private int type;
                private int status;
                private int has_comments;
                private int user_bury;
                private String status_desc;
                private int display_type;
                private boolean is_personal_show;
                private int user_digg;
                private float online_time;
                private String category_name;
                private boolean category_visible;
                private int bury_count;
                private boolean is_anonymous;
                private int repin_count;
                private int digg_count;
                private int has_hot_comments;
                private boolean allow_dislike;
                private int user_repin;
                private Activity activity;
                private long group_id;
                private int category_id;

                public void setText(String text) {
                    this.text = text;
                }

                public String getText() {
                    return text;
                }

                public void setDislike_reason(List<Dislike_reason> dislike_reason) {
                    this.dislike_reason = dislike_reason;
                }

                public List<Dislike_reason> getDislike_reason() {
                    return dislike_reason;
                }

                public void setCreate_time(float create_time) {
                    this.create_time = create_time;
                }

                public float getCreate_time() {
                    return create_time;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public long getId() {
                    return id;
                }

                public void setFavorite_count(int favorite_count) {
                    this.favorite_count = favorite_count;
                }

                public int getFavorite_count() {
                    return favorite_count;
                }

                public void setGo_detail_count(int go_detail_count) {
                    this.go_detail_count = go_detail_count;
                }

                public int getGo_detail_count() {
                    return go_detail_count;
                }

                public void setUser_favorite(int user_favorite) {
                    this.user_favorite = user_favorite;
                }

                public int getUser_favorite() {
                    return user_favorite;
                }

                public void setShare_type(int share_type) {
                    this.share_type = share_type;
                }

                public int getShare_type() {
                    return share_type;
                }

                public void setUser(User user) {
                    this.user = user;
                }

                public User getUser() {
                    return user;
                }

                public void setIs_can_share(int is_can_share) {
                    this.is_can_share = is_can_share;
                }

                public int getIs_can_share() {
                    return is_can_share;
                }

                public void setCategory_type(int category_type) {
                    this.category_type = category_type;
                }

                public int getCategory_type() {
                    return category_type;
                }

                public void setShare_url(String share_url) {
                    this.share_url = share_url;
                }

                public String getShare_url() {
                    return share_url;
                }

                public void setLabel(int label) {
                    this.label = label;
                }

                public int getLabel() {
                    return label;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getContent() {
                    return content;
                }

                public void setComment_count(int comment_count) {
                    this.comment_count = comment_count;
                }

                public int getComment_count() {
                    return comment_count;
                }

                public void setId_str(String id_str) {
                    this.id_str = id_str;
                }

                public String getId_str() {
                    return id_str;
                }

                public void setMedia_type(int media_type) {
                    this.media_type = media_type;
                }

                public int getMedia_type() {
                    return media_type;
                }

                public void setShare_count(int share_count) {
                    this.share_count = share_count;
                }

                public int getShare_count() {
                    return share_count;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public int getType() {
                    return type;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getStatus() {
                    return status;
                }

                public void setHas_comments(int has_comments) {
                    this.has_comments = has_comments;
                }

                public int getHas_comments() {
                    return has_comments;
                }

                public void setUser_bury(int user_bury) {
                    this.user_bury = user_bury;
                }

                public int getUser_bury() {
                    return user_bury;
                }

                public void setStatus_desc(String status_desc) {
                    this.status_desc = status_desc;
                }

                public String getStatus_desc() {
                    return status_desc;
                }

                public void setDisplay_type(int display_type) {
                    this.display_type = display_type;
                }

                public int getDisplay_type() {
                    return display_type;
                }

                public void setIs_personal_show(boolean is_personal_show) {
                    this.is_personal_show = is_personal_show;
                }

                public boolean getIs_personal_show() {
                    return is_personal_show;
                }

                public void setUser_digg(int user_digg) {
                    this.user_digg = user_digg;
                }

                public int getUser_digg() {
                    return user_digg;
                }

                public void setOnline_time(float online_time) {
                    this.online_time = online_time;
                }

                public float getOnline_time() {
                    return online_time;
                }

                public void setCategory_name(String category_name) {
                    this.category_name = category_name;
                }

                public String getCategory_name() {
                    return category_name;
                }

                public void setCategory_visible(boolean category_visible) {
                    this.category_visible = category_visible;
                }

                public boolean getCategory_visible() {
                    return category_visible;
                }

                public void setBury_count(int bury_count) {
                    this.bury_count = bury_count;
                }

                public int getBury_count() {
                    return bury_count;
                }

                public void setIs_anonymous(boolean is_anonymous) {
                    this.is_anonymous = is_anonymous;
                }

                public boolean getIs_anonymous() {
                    return is_anonymous;
                }

                public void setRepin_count(int repin_count) {
                    this.repin_count = repin_count;
                }

                public int getRepin_count() {
                    return repin_count;
                }

                public void setDigg_count(int digg_count) {
                    this.digg_count = digg_count;
                }

                public int getDigg_count() {
                    return digg_count;
                }

                public void setHas_hot_comments(int has_hot_comments) {
                    this.has_hot_comments = has_hot_comments;
                }

                public int getHas_hot_comments() {
                    return has_hot_comments;
                }

                public void setAllow_dislike(boolean allow_dislike) {
                    this.allow_dislike = allow_dislike;
                }

                public boolean getAllow_dislike() {
                    return allow_dislike;
                }

                public void setUser_repin(int user_repin) {
                    this.user_repin = user_repin;
                }

                public int getUser_repin() {
                    return user_repin;
                }

                public void setActivity(Activity activity) {
                    this.activity = activity;
                }

                public Activity getActivity() {
                    return activity;
                }

                public void setGroup_id(long group_id) {
                    this.group_id = group_id;
                }

                public long getGroup_id() {
                    return group_id;
                }

                public void setCategory_id(int category_id) {
                    this.category_id = category_id;
                }

                public int getCategory_id() {
                    return category_id;
                }

                @Override
                public String toString() {
                    return "Group{" +
                            "text='" + text + '\'' +
                            ", dislike_reason=" + dislike_reason +
                            ", create_time=" + create_time +
                            ", id=" + id +
                            ", favorite_count=" + favorite_count +
                            ", go_detail_count=" + go_detail_count +
                            ", user_favorite=" + user_favorite +
                            ", share_type=" + share_type +
                            ", user=" + user +
                            ", is_can_share=" + is_can_share +
                            ", category_type=" + category_type +
                            ", share_url='" + share_url + '\'' +
                            ", label=" + label +
                            ", content='" + content + '\'' +
                            ", comment_count=" + comment_count +
                            ", id_str='" + id_str + '\'' +
                            ", media_type=" + media_type +
                            ", share_count=" + share_count +
                            ", type=" + type +
                            ", status=" + status +
                            ", has_comments=" + has_comments +
                            ", user_bury=" + user_bury +
                            ", status_desc='" + status_desc + '\'' +
                            ", display_type=" + display_type +
                            ", is_personal_show=" + is_personal_show +
                            ", user_digg=" + user_digg +
                            ", online_time=" + online_time +
                            ", category_name='" + category_name + '\'' +
                            ", category_visible=" + category_visible +
                            ", bury_count=" + bury_count +
                            ", is_anonymous=" + is_anonymous +
                            ", repin_count=" + repin_count +
                            ", digg_count=" + digg_count +
                            ", has_hot_comments=" + has_hot_comments +
                            ", allow_dislike=" + allow_dislike +
                            ", user_repin=" + user_repin +
                            ", activity=" + activity +
                            ", group_id=" + group_id +
                            ", category_id=" + category_id +
                            '}';
                }

                public class Dislike_reason {

                    private int type;
                    private long id;
                    private String title;

                    public void setType(int type) {
                        this.type = type;
                    }

                    public int getType() {
                        return type;
                    }

                    public void setId(long id) {
                        this.id = id;
                    }

                    public long getId() {
                        return id;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getTitle() {
                        return title;
                    }

                    @Override
                    public String toString() {
                        return "Dislike_reason{" +
                                "type=" + type +
                                ", id=" + id +
                                ", title='" + title + '\'' +
                                '}';
                    }
                }

                public class User {

                    private long user_id;
                    private String name;
                    private int followings;
                    private boolean user_verified;
                    private int ugc_count;
                    private String avatar_url;
                    private int followers;
                    private boolean is_following;
                    private boolean is_pro_user;

                    public void setUser_id(long user_id) {
                        this.user_id = user_id;
                    }

                    public long getUser_id() {
                        return user_id;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setFollowings(int followings) {
                        this.followings = followings;
                    }

                    public int getFollowings() {
                        return followings;
                    }

                    public void setUser_verified(boolean user_verified) {
                        this.user_verified = user_verified;
                    }

                    public boolean getUser_verified() {
                        return user_verified;
                    }

                    public void setUgc_count(int ugc_count) {
                        this.ugc_count = ugc_count;
                    }

                    public int getUgc_count() {
                        return ugc_count;
                    }

                    public void setAvatar_url(String avatar_url) {
                        this.avatar_url = avatar_url;
                    }

                    public String getAvatar_url() {
                        return avatar_url;
                    }

                    public void setFollowers(int followers) {
                        this.followers = followers;
                    }

                    public int getFollowers() {
                        return followers;
                    }

                    public void setIs_following(boolean is_following) {
                        this.is_following = is_following;
                    }

                    public boolean getIs_following() {
                        return is_following;
                    }

                    public void setIs_pro_user(boolean is_pro_user) {
                        this.is_pro_user = is_pro_user;
                    }

                    public boolean getIs_pro_user() {
                        return is_pro_user;
                    }

                    @Override
                    public String toString() {
                        return "User{" +
                                "user_id=" + user_id +
                                ", name='" + name + '\'' +
                                ", followings=" + followings +
                                ", user_verified=" + user_verified +
                                ", ugc_count=" + ugc_count +
                                ", avatar_url='" + avatar_url + '\'' +
                                ", followers=" + followers +
                                ", is_following=" + is_following +
                                ", is_pro_user=" + is_pro_user +
                                '}';
                    }
                }

                public class Activity {

                }
            }
        }
    }
}
