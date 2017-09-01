package com.ymzs.funreading.model.remote.adapter;

import com.ymzs.funreading.model.Fun;
import com.ymzs.funreading.model.FunAdapter;
import com.ymzs.funreading.model.remote.ApiConstants;
import com.ymzs.funreading.model.remote.entity.NhdzFun;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xumingtao on 2017/8/29.
 */

public class NhdzFunAdapter implements FunAdapter {

    private NhdzFun mNhdzFun;

    public NhdzFunAdapter(NhdzFun fun){
        mNhdzFun = fun;
    }

    @Override
    public List<Fun> getFuns() {
        List<Fun> funs = new ArrayList<Fun>();
        List<NhdzFun.DataX.Data> dataList = mNhdzFun.getData().getData();
        for(NhdzFun.DataX.Data data : dataList){
            Fun fun = new Fun();
            NhdzFun.DataX.Data.Group group = data.getGroup();
            fun.setAuthor(group.getUser().getName());
            Date date = new Date((long)group.getOnline_time() * 1000);
            String time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
            fun.setTime(time);
            fun.setContent(group.getContent());
            fun.setType(ApiConstants.API_TYPE_NHDZ);
            funs.add(fun);
        }
        return funs;
    }
}
