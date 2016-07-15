package com.example.jiawei.picassodemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiawei.picassodemo.R;
import com.example.jiawei.picassodemo.bean.BaseBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by QYer on 2016/7/15.
 */
public class MyAdapter extends BaseAdapter {


    private Context context;
    private List<BaseBean.DataBean.ListBean> list;
    private final LayoutInflater inflater;


    public MyAdapter(Context context, List<BaseBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.shangpin_item, parent, false);
        TextView price = (TextView) view.findViewById(R.id.tv_jiage);
        ImageView pic= (ImageView) view.findViewById(R.id.iv_shangpin);
        price.setText(list.get(position).getUnitCost()+"");
        Picasso.with(context).load(list.get(position).getPhotoUrl()+"").into(pic);
        return view;
    }
}
