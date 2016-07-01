package com.example.jiawei.fragmenttabhost;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by QYer on 2016/7/1.
 */
public class ConversationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TextView textView=new TextView(getActivity());
        textView.setTextSize(20);
        textView.setText("ConversationFragment");
        textView.setTextColor(Color.BLACK);

        return textView;
    }
}
