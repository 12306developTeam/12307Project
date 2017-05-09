package com.example.administrator.train;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/4/25.
 */
public class TitleFragment extends Fragment{

   // TextView title;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View TitleLayout = inflater.inflate(R.layout.titlebar, container, false);
        //title = (TextView)TitleLayout.findViewById(R.id.title_text);
        return TitleLayout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}

