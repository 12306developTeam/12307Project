package com.example.administrator.train;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    private FragmentManager mFragmentManager;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取FragmentManager
        mFragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction2 = mFragmentManager.beginTransaction();
        Fragment fragment2 = new TitleFragment();
        transaction2.replace(R.id.title, fragment2);
        transaction2.commit();
        //获取radioGroup控件
        radioGroup = (RadioGroup) findViewById(R.id.rg_group);

        //监听点击按钮事件,实现不同Fragment之间的切换
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Fragment fragment = FragmentFactory.getInstanceByIndex(checkedId);
                switchContent(fragment);
            }
        });
    }

    //刷新界面
    public void switchContent(Fragment fragment) {
        try{
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.replace(R.id.content, fragment);
            transaction.commit();
        }
        catch(Exception e)
        {
            System.out.println("主类调用异常:"+e);
        }
    }
}//class

