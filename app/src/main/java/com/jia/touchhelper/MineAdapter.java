package com.jia.touchhelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description:
 * Created by jia on 2018/3/6.
 * 人之所以能，是相信能
 */

public class MineAdapter extends RecyclerView.Adapter<MineAdapter.MineViewHolder> {

    private Context context;

    private List<String> list;

    public MineAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_mine, parent, false);
        return new MineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MineViewHolder holder, int position) {

        holder.textView.setText(list.get(position));
        holder.ivClose.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MineViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.iv_close)
        ImageView ivClose;

        public MineViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
