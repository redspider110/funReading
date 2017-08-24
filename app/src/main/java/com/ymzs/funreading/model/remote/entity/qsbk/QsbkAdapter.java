package com.ymzs.funreading.model.remote.entity.qsbk;

import com.ymzs.funreading.model.Fun;
import com.ymzs.funreading.model.FunAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xumingtao on 2017/8/23.
 */

public class QsbkAdapter implements FunAdapter {

    private QsbkFun mQsbkFun;

    public QsbkAdapter(QsbkFun fun){
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
            fun.setTime(item.getPublished_at());
            fun.setContent(item.getContent());
            funs.add(fun);
        }
        return funs;
    }
}
