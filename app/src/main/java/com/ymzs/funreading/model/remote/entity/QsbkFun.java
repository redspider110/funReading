package com.ymzs.funreading.model.remote.entity;

import java.util.List;

/**
 * Created by xumingtao on 2017/8/23.
 */

public class QsbkFun {

    private int count;
    private int err;
    private int total;
    private int page;
    private int refresh;
    private List<Item> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRefresh() {
        return refresh;
    }

    public void setRefresh(int refresh) {
        this.refresh = refresh;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public class Item{
        private String format;
        private String image;
        private long published_at;
        private String tag;
        private User user;
        private long image_size;
        private long id;
        private Votes votes;
        private long created_at;
        private String content;
        private String state;
        private int comments_count;
        private boolean allow_comment;
        private int share_count;

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public long getPublished_at() {
            return published_at;
        }

        public void setPublished_at(long published_at) {
            this.published_at = published_at;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public long getImage_size() {
            return image_size;
        }

        public void setImage_size(long image_size) {
            this.image_size = image_size;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public Votes getVotes() {
            return votes;
        }

        public void setVotes(Votes votes) {
            this.votes = votes;
        }

        public long getCreated_at() {
            return created_at;
        }

        public void setCreated_at(long created_at) {
            this.created_at = created_at;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public boolean isAllow_comment() {
            return allow_comment;
        }

        public void setAllow_comment(boolean allow_comment) {
            this.allow_comment = allow_comment;
        }

        public int getShare_count() {
            return share_count;
        }

        public void setShare_count(int share_count) {
            this.share_count = share_count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Item)) return false;

            Item item = (Item) o;

            if (getPublished_at() != item.getPublished_at()) return false;
            if (getImage_size() != item.getImage_size()) return false;
            if (getId() != item.getId()) return false;
            if (getCreated_at() != item.getCreated_at()) return false;
            if (getComments_count() != item.getComments_count()) return false;
            if (isAllow_comment() != item.isAllow_comment()) return false;
            if (getShare_count() != item.getShare_count()) return false;
            if (!getFormat().equals(item.getFormat())) return false;
            if (!getImage().equals(item.getImage())) return false;
            if (!getTag().equals(item.getTag())) return false;
            if (!getUser().equals(item.getUser())) return false;
            if (!getVotes().equals(item.getVotes())) return false;
            if (!getContent().equals(item.getContent())) return false;
            return getState().equals(item.getState());

        }

        @Override
        public int hashCode() {
            int result = getFormat().hashCode();
            result = 31 * result + getImage().hashCode();
            result = 31 * result + (int) (getPublished_at() ^ (getPublished_at() >>> 32));
            result = 31 * result + getTag().hashCode();
            result = 31 * result + getUser().hashCode();
            result = 31 * result + (int) (getImage_size() ^ (getImage_size() >>> 32));
            result = 31 * result + (int) (getId() ^ (getId() >>> 32));
            result = 31 * result + getVotes().hashCode();
            result = 31 * result + (int) (getCreated_at() ^ (getCreated_at() >>> 32));
            result = 31 * result + getContent().hashCode();
            result = 31 * result + getState().hashCode();
            result = 31 * result + getComments_count();
            result = 31 * result + (isAllow_comment() ? 1 : 0);
            result = 31 * result + getShare_count();
            return result;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "format='" + format + '\'' +
                    ", image='" + image + '\'' +
                    ", published_at=" + published_at +
                    ", tag='" + tag + '\'' +
                    ", user=" + user +
                    ", image_size=" + image_size +
                    ", id=" + id +
                    ", votes=" + votes +
                    ", created_at=" + created_at +
                    ", content='" + content + '\'' +
                    ", state='" + state + '\'' +
                    ", comments_count=" + comments_count +
                    ", allow_comment=" + allow_comment +
                    ", share_count=" + share_count +
                    '}';
        }
    }

    public class User{
        private long avatar_updated_at;
        private long created_at;
        private String medium;
        private String thumb;
        private long uid;
        private long last_visited_at;
        private String gender;
        private int age;
        private long updated_at;
        private String state;
        private String role;
        private String astrology;
        private String login;
        private String last_device;
        private long id;
        private String icon;

        public long getAvatar_updated_at() {
            return avatar_updated_at;
        }

        public void setAvatar_updated_at(long avatar_updated_at) {
            this.avatar_updated_at = avatar_updated_at;
        }

        public long getCreated_at() {
            return created_at;
        }

        public void setCreated_at(long created_at) {
            this.created_at = created_at;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public long getUid() {
            return uid;
        }

        public void setUid(long uid) {
            this.uid = uid;
        }

        public long getLast_visited_at() {
            return last_visited_at;
        }

        public void setLast_visited_at(long last_visited_at) {
            this.last_visited_at = last_visited_at;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public long getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(long updated_at) {
            this.updated_at = updated_at;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getAstrology() {
            return astrology;
        }

        public void setAstrology(String astrology) {
            this.astrology = astrology;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getLast_device() {
            return last_device;
        }

        public void setLast_device(String last_device) {
            this.last_device = last_device;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;

            User user = (User) o;

            if (getAvatar_updated_at() != user.getAvatar_updated_at()) return false;
            if (getCreated_at() != user.getCreated_at()) return false;
            if (getUid() != user.getUid()) return false;
            if (getLast_visited_at() != user.getLast_visited_at()) return false;
            if (getAge() != user.getAge()) return false;
            if (getUpdated_at() != user.getUpdated_at()) return false;
            if (getId() != user.getId()) return false;
            if (!getMedium().equals(user.getMedium())) return false;
            if (!getThumb().equals(user.getThumb())) return false;
            if (!getGender().equals(user.getGender())) return false;
            if (!getState().equals(user.getState())) return false;
            if (!getRole().equals(user.getRole())) return false;
            if (!getAstrology().equals(user.getAstrology())) return false;
            if (!getLogin().equals(user.getLogin())) return false;
            if (!getLast_device().equals(user.getLast_device())) return false;
            return getIcon().equals(user.getIcon());

        }

        @Override
        public int hashCode() {
            int result = (int) (getAvatar_updated_at() ^ (getAvatar_updated_at() >>> 32));
            result = 31 * result + (int) (getCreated_at() ^ (getCreated_at() >>> 32));
            result = 31 * result + getMedium().hashCode();
            result = 31 * result + getThumb().hashCode();
            result = 31 * result + (int) (getUid() ^ (getUid() >>> 32));
            result = 31 * result + (int) (getLast_visited_at() ^ (getLast_visited_at() >>> 32));
            result = 31 * result + getGender().hashCode();
            result = 31 * result + getAge();
            result = 31 * result + (int) (getUpdated_at() ^ (getUpdated_at() >>> 32));
            result = 31 * result + getState().hashCode();
            result = 31 * result + getRole().hashCode();
            result = 31 * result + getAstrology().hashCode();
            result = 31 * result + getLogin().hashCode();
            result = 31 * result + getLast_device().hashCode();
            result = 31 * result + (int) (getId() ^ (getId() >>> 32));
            result = 31 * result + getIcon().hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "User{" +
                    "avatar_updated_at=" + avatar_updated_at +
                    ", created_at=" + created_at +
                    ", medium='" + medium + '\'' +
                    ", thumb='" + thumb + '\'' +
                    ", uid=" + uid +
                    ", last_visited_at=" + last_visited_at +
                    ", gender='" + gender + '\'' +
                    ", age=" + age +
                    ", updated_at=" + updated_at +
                    ", state='" + state + '\'' +
                    ", role='" + role + '\'' +
                    ", astrology='" + astrology + '\'' +
                    ", login='" + login + '\'' +
                    ", last_device='" + last_device + '\'' +
                    ", id=" + id +
                    ", icon='" + icon + '\'' +
                    '}';
        }
    }

    public class Votes{
        private int down;
        private int up;

        public int getDown() {
            return down;
        }

        public void setDown(int down) {
            this.down = down;
        }

        public int getUp() {
            return up;
        }

        public void setUp(int up) {
            this.up = up;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Votes)) return false;

            Votes votes = (Votes) o;

            if (getDown() != votes.getDown()) return false;
            return getUp() == votes.getUp();

        }

        @Override
        public int hashCode() {
            int result = getDown();
            result = 31 * result + getUp();
            return result;
        }

        @Override
        public String toString() {
            return "Votes{" +
                    "down=" + down +
                    ", up=" + up +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QsbkFun)) return false;

        QsbkFun qsbkText = (QsbkFun) o;

        if (getCount() != qsbkText.getCount()) return false;
        if (getErr() != qsbkText.getErr()) return false;
        if (getTotal() != qsbkText.getTotal()) return false;
        if (getPage() != qsbkText.getPage()) return false;
        if (getRefresh() != qsbkText.getRefresh()) return false;
        return getItems().equals(qsbkText.getItems());
    }

    @Override
    public int hashCode() {
        int result = getCount();
        result = 31 * result + getErr();
        result = 31 * result + getTotal();
        result = 31 * result + getPage();
        result = 31 * result + getRefresh();
        result = 31 * result + getItems().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "QsbkFun{" +
                "count=" + count +
                ", err=" + err +
                ", total=" + total +
                ", page=" + page +
                ", refresh=" + refresh +
                ", items=" + items +
                '}';
    }
}
