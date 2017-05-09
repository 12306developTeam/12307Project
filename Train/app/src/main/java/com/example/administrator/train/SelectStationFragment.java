package com.example.administrator.train;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.train.http.HttpCallbackListener;
import com.example.administrator.train.http.HttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 */
public class SelectStationFragment extends Fragment{

    private RadioGroup radioGroup;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> dataList = new ArrayList<>();
    private String  TYPE;
    MainActivity main;
    SharedPreferences.Editor editor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.station_select, container, false);
        View view2 = inflater.inflate(R.layout.activity_index, container, false);
        radioGroup = (RadioGroup) view.findViewById(R.id.station_group);
        listView = (ListView) view.findViewById(R.id.list_view);
        adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,dataList);
        main = (MainActivity) getActivity();
        listView.setAdapter(adapter);

        if(getArguments() !=null){
            if((getArguments().getString("station")).equals("station1")) {
                TYPE="station1";
            }else{
                TYPE="station2";
            }
        }
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);


        //选择常用车站、热门车站、车站列表
        dataList.add("南昌");
        dataList.add("上饶");
        dataList.add("北京");
        dataList.add("上海");
        adapter.notifyDataSetChanged();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.usual_station){

                }else if(checkedId == R.id.hot_station){

                    dataList.clear();
                    dataList.add("江西");
                    dataList.add("江西");
                    dataList.add("江西");
                    dataList.add("江西");
                    adapter.notifyDataSetChanged();
                }else if (checkedId == R.id.station_list){
                    dataList.clear();
                    dataList.add("江西");
                    adapter.notifyDataSetChanged();
                    String address;
                    address="http://59.110.239.109:8080/12307/station?name=%E5%8C%97";
                    queryStation(address);
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IndexFragment fragment= new IndexFragment();

                if(TYPE.equals("station1")) {
                    editor = main.getSharedPreferences("data", Context.MODE_APPEND).edit();
                    editor.putString("station1",dataList.get(position) );
                    editor.apply();
                }else {
                    editor = main.getSharedPreferences("data", Context.MODE_APPEND).edit();
                    editor.putString("station2",dataList.get(position));
                    editor.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putString("station", TYPE);
                fragment.setArguments(bundle);
                main.switchContent(fragment);

            }
        });

    }

    public void queryStation(String address){

        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {

                dataList.add(response.toString());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
