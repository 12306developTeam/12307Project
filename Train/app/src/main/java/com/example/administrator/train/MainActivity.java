package com.example.administrator.train;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

public class MainActivity extends FragmentActivity {

    private FragmentManager mFragmentManager;
    private FragmentTransaction transaction;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putString("station1","南昌");
        editor.putString("station2", "上海");
        editor.apply();

        //获取FragmentManager
        mFragmentManager = getSupportFragmentManager();

        //修改标题栏
       // mFragmentManager.beginTransaction().replace(R.id.title, new TitleFragment()).commit();

        //获取radioGroup控件
        radioGroup = (RadioGroup) findViewById(R.id.rg_group);

        //开始默认跳转到方案查询界面
        switchContent(FragmentFactory.getInstanceByIndex(R.id.scheme_query));
        //监听点击按钮事件,实现不同Fragment之间的切换
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Fragment fragment = FragmentFactory.getInstanceByIndex(checkedId);
                switchContent(fragment);
            }
        });
    }

    //替换界面
    public void switchContent(Fragment fragment) {
        try{
            transaction =  mFragmentManager.beginTransaction();
            transaction.replace(R.id.content, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        catch(Exception e)
        {
            System.out.println("主类调用异常:"+e);
        }
    }

    //替换标题
    public void switchTitle(Fragment fragment) {
        try{
            transaction =  mFragmentManager.beginTransaction();
            transaction.replace(R.id.title, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        catch(Exception e)
        {
            System.out.println("主类调用异常:"+e);
        }
    }
}//class

