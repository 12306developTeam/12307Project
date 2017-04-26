package com.example.administrator.train;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2017/4/25.
 */
public class TitleFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View TitleLayout = inflater.inflate(R.layout.titlebar, container, false);
        return TitleLayout;
    }

}

