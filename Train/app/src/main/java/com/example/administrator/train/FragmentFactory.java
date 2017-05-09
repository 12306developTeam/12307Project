package com.example.administrator.train;

/**
 * Created by Administrator on 2017/4/25.
 */
import android.support.v4.app.Fragment;


/**
 * 定义一个工厂模式，
 * 来实现根据下标的位置返回相应的Fragment
 */
public class FragmentFactory {
    public static Fragment getInstanceByIndex(int index) {
        Fragment fragment = null;
        switch (index) {

            case R.id.scheme_query:
                fragment = new IndexFragment();
                break;

            case R.id.time_query:

                break;

            case R.id.my_account:
                fragment = new MyAccountFragment();
                break;

            case R.id.setting:
                fragment = new SettingFragment();
                break;
        }
        return fragment;
    }
}
