package com.example.myapplication.adap;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.HotBean;

import java.util.List;

public class AdAp extends RecyclerView.Adapter<AdAp.ViewH> {
    List<HotBean.RecentBean> recent;

    public AdAp(List<HotBean.RecentBean> recent) {
        this.recent = recent;
    }

    @NonNull
    @Override
    public ViewH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot, null);
        ViewH viewH = new ViewH(inflate);
        return viewH;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewH viewH, int i) {
        viewH.tv.setText(recent.get(i).getTitle());
        Glide.with(viewH.iv.getContext()).load(recent.get(i).getThumbnail()).into(viewH.iv);

    }

    @Override
    public int getItemCount() {
        return recent.size();
    }

    public class ViewH extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        public ViewH(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv=itemView.findViewById(R.id.tv);
        }
    }
}
