package com.example.jiawei.scrolistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Integer> list=new ArrayList<Integer>();

    ExpandableHeightGridView grid;
    ExpandableHeightGridView grid1;
    LayoutInflater inflater;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater = getLayoutInflater().from(this);

        imageView= (ImageView) findViewById(R.id.imageview);

        list.add(android.R.drawable.ic_btn_speak_now);
        list.add(android.R.drawable.ic_delete);
        list.add(android.R.drawable.ic_dialog_alert);
        list.add(android.R.drawable.ic_dialog_dialer);
        list.add(android.R.drawable.ic_dialog_email);
        list.add(android.R.drawable.ic_input_get);
        list.add(android.R.drawable.arrow_up_float);
        list.add(android.R.drawable.ic_media_ff);
        list.add(android.R.drawable.ic_btn_speak_now);
        list.add(android.R.drawable.ic_delete);
        list.add(android.R.drawable.ic_dialog_alert);
        list.add(android.R.drawable.ic_dialog_dialer);
        list.add(android.R.drawable.ic_dialog_email);
        list.add(android.R.drawable.ic_input_get);
        list.add(android.R.drawable.arrow_up_float);
        list.add(android.R.drawable.ic_media_ff);
        list.add(android.R.drawable.ic_btn_speak_now);
        list.add(android.R.drawable.ic_delete);
        list.add(android.R.drawable.ic_dialog_alert);
        list.add(android.R.drawable.ic_dialog_dialer);
        list.add(android.R.drawable.ic_dialog_email);
        list.add(android.R.drawable.ic_input_get);
        list.add(android.R.drawable.arrow_up_float);
        list.add(android.R.drawable.ic_media_ff);
        list.add(android.R.drawable.ic_btn_speak_now);
        list.add(android.R.drawable.ic_delete);
        list.add(android.R.drawable.ic_dialog_alert);
        list.add(android.R.drawable.ic_dialog_dialer);
        list.add(android.R.drawable.ic_dialog_email);
        list.add(android.R.drawable.ic_input_get);
        list.add(android.R.drawable.arrow_up_float);
        list.add(android.R.drawable.ic_media_ff);

        grid= (ExpandableHeightGridView) findViewById(R.id.spotsView);
        grid1= (ExpandableHeightGridView) findViewById(R.id.spotsView1);

        GridAdapter adapter=new GridAdapter();

        grid.setAdapter(adapter);
        grid1.setAdapter(adapter);

    }

    class GridAdapter extends BaseAdapter{

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
            ViewHolder viewHolder;
            if(convertView==null){
                viewHolder=new ViewHolder();
                convertView=inflater.inflate(R.layout.item,parent,false);
                viewHolder.imageView= (ImageView) convertView.findViewById(R.id.imageview);
                convertView.setTag(viewHolder);
            }else{
                viewHolder= (ViewHolder) convertView.getTag();
            }

            viewHolder.imageView.setImageResource(list.get(position));

            return convertView;
        }
    }
    class ViewHolder {
        ImageView imageView;
    }
}
