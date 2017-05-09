package com.example.administrator.train;

/**
 * Created by Administrator on 2017/4/25.
 */

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.train.model.User;

public class LoginFragment extends Fragment{

    Button login;
    Button register;
    EditText name;
    EditText password;
    CheckBox remeber_password;
    CheckBox auto_login;
    TextView forget_password;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
        View loginLayout = inflater.inflate(R.layout.activity_login, container, false);
        login = (Button) loginLayout.findViewById(R.id.login_btn);
        register = (Button) loginLayout.findViewById(R.id.register_btn);
        name = (EditText) loginLayout.findViewById(R.id.edit_name);
        password = (EditText) loginLayout.findViewById(R.id.edit_password);
        remeber_password = (CheckBox) loginLayout.findViewById(R.id.checkBox);
        auto_login = (CheckBox) loginLayout.findViewById(R.id.checkBox2);
        forget_password = (TextView) loginLayout.findViewById(R.id.forget);

        return loginLayout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        //点击登录
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText() != null) {
                    new AlertDialog.Builder(getActivity()).setTitle("温馨提示")
                            .setMessage("请输入登录名！")
                            .setPositiveButton("确定", null).show();
                } else {
                    User user = new User();

                }
            }
        });

        //点击注册
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //得到Fragment2里边控件内容
                RegisterFragment fragment= new RegisterFragment();
                MainActivity ma = (MainActivity) getActivity();
                ma.switchContent(fragment);
            }
        });
    }
}
