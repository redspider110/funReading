package com.ymzs.funreading.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.common.base.Strings;
import com.ymzs.funreading.R;
import com.ymzs.funreading.model.Fun;

import java.util.List;

/**
 * Created by xumingtao on 2017/8/22.
 */

public class FunListAdapter extends RecyclerView.Adapter<FunListAdapter.FunListViewHolder> {
    private Context mContext;
    private List<Fun> mFunList;

    public FunListAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<Fun> funs){
        mFunList = funs;
        notifyDataSetChanged();
    }

    @Override
    public FunListAdapter.FunListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        FunListViewHolder holder = new FunListViewHolder(layoutInflater.inflate(R.layout.fun_list_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(FunListAdapter.FunListViewHolder holder, int position) {
        Fun fun = mFunList.get(position);
        String author = fun.getAuthor();
        if(Strings.isNullOrEmpty(author)){
            author = mContext.getString(R.string.unknown_author);
        }
        holder.mTvAuthor.setText(author);
        holder.mTvTime.setText(String.valueOf(fun.getTime()));
        holder.mTvContent.setText(fun.getContent());
    }

    @Override
    public int getItemCount() {
        return mFunList.size();
    }

    class FunListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView mTvAuthor;
        TextView mTvTime;
        TextView mTvContent;

        public FunListViewHolder(View itemView) {
            super(itemView);
            mTvAuthor = (TextView) itemView.findViewById(R.id.fun_list_item_tv_author);
            mTvTime = (TextView) itemView.findViewById(R.id.fun_list_item_tv_time);
            mTvContent = (TextView) itemView.findViewById(R.id.fun_list_item_tv_content);
        }

        @Override
        public void onClick(View v) {

        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }
}
