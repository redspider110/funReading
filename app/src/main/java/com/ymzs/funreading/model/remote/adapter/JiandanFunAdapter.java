package com.ymzs.funreading.model.remote.adapter;

import com.ymzs.funreading.model.Fun;
import com.ymzs.funreading.model.FunAdapter;
import com.ymzs.funreading.model.remote.ApiConstants;
import com.ymzs.funreading.model.remote.entity.JiandanFun;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xumingtao on 2017/8/29.
 */

public class JiandanFunAdapter implements FunAdapter {

    private JiandanFun mJiandanFun;

    public JiandanFunAdapter(JiandanFun fun){
        mJiandanFun = fun;
    }

    @Override
    public List<Fun> getFuns() {
        List<Fun> funs = new ArrayList<Fun>();
        List<JiandanFun.Comments> comments = mJiandanFun.getComments();
        for (JiandanFun.Comments comment : comments){
            Fun fun = new Fun();
            fun.setAuthor(comment.getComment_author());
            fun.setTime(comment.getComment_date());
            fun.setContent(comment.getComment_content());
            fun.setType(ApiConstants.API_TYPE_JIANDAN);
            funs.add(fun);
        }
        return funs;
    }
}
