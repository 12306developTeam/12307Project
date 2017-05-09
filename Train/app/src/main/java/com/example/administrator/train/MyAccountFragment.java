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

public class MyAccountFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myAccountLayout = inflater.inflate(R.layout.activity_myaccount, container, false);

        return myAccountLayout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        TextView personInfo = (TextView) getActivity().findViewById(R.id.person_info);
        personInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //得到Fragment2里边控件内容
                PersonInfoFragment fragment = new PersonInfoFragment();
                MainActivity ma = (MainActivity) getActivity();
                ma.switchContent(fragment);
            }
        });
    }
}
