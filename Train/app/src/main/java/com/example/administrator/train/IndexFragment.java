package com.example.administrator.train;

/**
 * Created by Administrator on 2017/4/26.
 */
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class IndexFragment extends Fragment{

    TextView station1;
    TextView station2;
    ImageView circle;
    Button query;
    String stationName1;
    String stationName2;

    MainActivity main;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View indexLayout = inflater.inflate(R.layout.activity_index, container, false);

        station1 = (TextView) indexLayout.findViewById(R.id.station1);
        station2 = (TextView) indexLayout.findViewById(R.id.station2);
        circle = (ImageView) indexLayout.findViewById(R.id.circle);
        query = (Button) indexLayout.findViewById(R.id.query_btn);
        main = (MainActivity) getActivity();
        //显示客户目标的车站
        SharedPreferences info = getActivity().getSharedPreferences("data", Context.MODE_APPEND);
        stationName1 = info.getString("station1","");
        stationName2 = info.getString("station2", "");
        station1.setText(stationName1);
        station2.setText(stationName2);

        return indexLayout;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        //跳转到选择搜索界面
        station1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectStationFragment fragment= new SelectStationFragment();
                MainActivity main = (MainActivity) getActivity();
                Bundle bundle = new Bundle();
                bundle.putString("station","station1");
                fragment.setArguments(bundle);
                main.switchContent(fragment);
            }
        });
        //跳转到选择搜索界面
        station2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectStationFragment fragment= new SelectStationFragment();
                MainActivity main = (MainActivity) getActivity();
                Bundle bundle = new Bundle();
                bundle.putString("station","station2");
                fragment.setArguments(bundle);
                main.switchContent(fragment);
            }
        });

        //对调车站方向
        circle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                SharedPreferences info = main.getSharedPreferences("data", Context.MODE_APPEND);
                stationName1 = info.getString("station1","");
                stationName2 = info.getString("station2", "");
                station1.setText(stationName2);
                station2.setText(stationName1);
                SharedPreferences.Editor editor = main.getSharedPreferences("data", Context.MODE_PRIVATE).edit();
                editor.putString("station1", stationName2);
                editor.putString("station2", stationName1);
                editor.apply();
            }
        });

        //点击查询车次
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
