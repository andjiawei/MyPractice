package com.example.jiawei.expandlistdemo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ExpandableListView.OnGroupClickListener, ExpandableListView.OnChildClickListener {

    ExpandableListView exListView;
    private int [] arrayParent=new int[]{1,2,3,4,5,6,7,8,9,10};
    private int [][] arrayChild=new int[][] {arrayParent,arrayParent,arrayParent,arrayParent,arrayParent,arrayParent,arrayParent,arrayParent,arrayParent,arrayParent};
    LayoutInflater inflater;
    Context context=this;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater = LayoutInflater.from(this);

        exListView= (ExpandableListView) findViewById(R.id.exListView);
        scrollView= (ScrollView) findViewById(R.id.scrollView);

        exListView.setOnGroupClickListener(this);//组点击事件
        exListView.setOnChildClickListener(this);//孩子点击
        //合上事件
        exListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {

                LinearLayout.LayoutParams param = (LinearLayout.LayoutParams) exListView.getLayoutParams();
                param.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                exListView.setLayoutParams(param);
                exListView.refreshDrawableState();
                scrollView.refreshDrawableState();

            }
        });
        //展开
        exListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

//                LinearLayout.LayoutParams param = (LinearLayout.LayoutParams) exListView.getLayoutParams();
//                param.height = (arrayChild[groupPosition].length * exListView.getHeight());
//                exListView.setLayoutParams(param);
//                exListView.refreshDrawableState();
//                scrollView.refreshDrawableState();
            }
        });

        exListView.setAdapter(new ExpandableAdapter());
    }

    private void setListViewHeight(ExpandableListView listView,
                                   int group) {
        ExpandableListAdapter listAdapter = (ExpandableListAdapter) listView.getExpandableListAdapter();
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.EXACTLY);
        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
            View groupItem = listAdapter.getGroupView(i, false, null, listView);
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

            totalHeight += groupItem.getMeasuredHeight();

            if (((listView.isGroupExpanded(i)) && (i != group))
                    || ((!listView.isGroupExpanded(i)) && (i == group))) {
                for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                    View listItem = listAdapter.getChildView(i, j, false, null,
                            listView);
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

                    totalHeight += listItem.getMeasuredHeight();

                }
            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        int height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
        if (height < 10)
            height = 200;
        params.height = height;
        listView.setLayoutParams(params);
        listView.requestLayout();

    }


    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        Log.e("onGroupClick","onGroupClick--"+groupPosition+"id--"+id);
        setListViewHeight(parent,groupPosition);
        return false;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        Log.e("onGroupClick","onChildClick--"+groupPosition+"id--"+childPosition);
        return false;
    }


    class ExpandableAdapter extends BaseExpandableListAdapter{

        @Override
        public int getGroupCount() {
            return arrayParent.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return arrayChild.length;
        }

        @Override
        public Integer getGroup(int groupPosition) {
            return arrayParent[groupPosition];
        }

        @Override
        public Integer getChild(int groupPosition, int childPosition) {
            return arrayChild[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return arrayChild[groupPosition][childPosition];
        }


        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            GroupViewholder vh;
            if(convertView==null){
                vh=new GroupViewholder();
                convertView= inflater.inflate(R.layout.parent_item, parent, false);
                vh.textView= (TextView) convertView.findViewById(R.id.textView);
                convertView.setTag(vh);
            }else{
                vh= (GroupViewholder) convertView.getTag();
            }
            vh.textView.setText(arrayParent[groupPosition]+"");
            if(isExpanded){
                vh.textView.setTextColor(Color.BLUE);
            }else{
                vh.textView.setTextColor(Color.RED);
            }
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ChildViewholder vh;
            if(convertView==null){
                vh=new ChildViewholder();
                convertView= inflater.inflate(R.layout.child_item, parent, false);
                vh.textView= (TextView) convertView.findViewById(R.id.textView);
                convertView.setTag(vh);
            }else{
                vh= (ChildViewholder) convertView.getTag();
            }
            vh.textView.setText(arrayChild[groupPosition][childPosition]+"");
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }
    }

    class GroupViewholder{
        TextView textView;
    }

    class ChildViewholder{
         TextView textView;
    }
}
