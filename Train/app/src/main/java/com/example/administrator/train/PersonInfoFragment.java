package com.example.administrator.train;

/**
 * Created by Administrator on 2017/4/26.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PersonInfoFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View personInfoLayout = inflater.inflate(R.layout.person_info, container, false);

        return personInfoLayout;
    }
}
