package com.example.administrator.train;

/**
 * Created by Administrator on 2017/4/26.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RegisterFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View RegisterLayout = inflater.inflate(R.layout.activity_register, container, false);

        return RegisterLayout;
    }

}
