package com.ymzs.funreading.model.remote.adapter;

import com.ymzs.funreading.model.Fun;
import com.ymzs.funreading.model.FunAdapter;
import com.ymzs.funreading.model.remote.ApiConstants;
import com.ymzs.funreading.model.remote.entity.QsbkFun;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xumingtao on 2017/8/23.
 */

public class QsbkFunAdapter implements FunAdapter {

    private QsbkFun mQsbkFun;

    public QsbkFunAdapter(QsbkFun fun){
        mQsbkFun = fun;
    }

    @Override
    public List<Fun> getFuns() {
        List<Fun> funs = new ArrayList<Fun>();
        List<QsbkFun.Item> items = mQsbkFun.getItems();
        for(QsbkFun.Item item : items){
            Fun fun = new Fun();
            QsbkFun.User user = item.getUser();
            if(user == null){
                fun.setAuthor("");
            }else{
                fun.setAuthor(user.getLogin());
            }
            Date date = new Date(item.getPublished_at() * 1000);
            String time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
            fun.setTime(time);
            fun.setContent(item.getContent());
            fun.setType(ApiConstants.API_TYPE_QSBK);
            funs.add(fun);
        }
        return funs;
    }
}
