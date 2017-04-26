package com.example.administrator.train;

/**
 * Created by Administrator on 2017/4/25.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginFragment extends Fragment{
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View loginLayout = inflater.inflate(R.layout.activity_login, container, false);

            return loginLayout;
        }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        Button bu = (Button)getActivity().findViewById(R.id.login_btn);
        bu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //得到Fragment2里边控件内容
                LoginFragment fragment= new LoginFragment();
                MainActivity ma = (MainActivity) getActivity();
                ma.switchContent(fragment);
            }
        });
        //后台设置布局
        //this.getView().setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
    }
}
