package com.example.administrator.train;

/**
 * Created by Administrator on 2017/4/26.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SettingFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View SettingLayout = inflater.inflate(R.layout.activity_setting, container, false);

        return SettingLayout;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        TextView login = (TextView) getActivity().findViewById(R.id.login);
        TextView register = (TextView) getActivity().findViewById(R.id.register);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //得到Fragment2里边控件内容
                LoginFragment fragment = new LoginFragment();
                MainActivity ma = (MainActivity) getActivity();
                ma.switchContent(fragment);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //得到Fragment2里边控件内容
                RegisterFragment fragment = new RegisterFragment();
                MainActivity ma = (MainActivity) getActivity();
                ma.switchContent(fragment);
            }
        });
    }

}
