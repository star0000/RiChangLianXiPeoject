package com.example.b.tablayoutfragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 墨羽 on 2018/2/26.
 */

public class ChannelFragment extends Fragment{

    private TextView tv;
    private String url;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        String name = bundle.getString("name");
        url = bundle.getString("url");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pager_item, container, false);
        tv = (TextView) view.findViewById(R.id.tv);
        tv.setText(url);
        return view;
    }
}
