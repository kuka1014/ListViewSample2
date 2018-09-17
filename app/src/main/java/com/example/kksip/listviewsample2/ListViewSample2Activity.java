package com.example.kksip.listviewsample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewSample2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_sample2);


        //Listview取得
        ListView lvMenu = findViewById(R.id.lvMenu);
        //リストビューに表示するリストデータ用オブジェクト作成
        List<String> menuList = new ArrayList<>();
        //リストデータの作成
        menuList.add("からあげ");
        menuList.add("ハンバーグ");
        menuList.add("しょうがやき");
        menuList.add("ステーキ");
        menuList.add("すきやき");
        menuList.add("たまごやき");
        menuList.add("にくじゃが");
        menuList.add("たまねぎ");
        menuList.add("さかな");

        //アダプタオブジェクト作成
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListViewSample2Activity.this,android.R.layout.simple_list_item_1,menuList);

        //リストビューにアダプタ設定
        lvMenu.setAdapter(adapter);

        //リストビューにリスナーせっってい
        lvMenu.setOnItemClickListener(new ListItemClickListener() );


    }

    /**
     * リストがタップ差sれ多ｔｐｋじの処理が
     */
    private  class ListItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            //注文確認ダイアログbフラグメントオブジェクト作成
            OrderConfirmDialogFragment dialogFragment =new OrderConfirmDialogFragment()
                    ;
            //ダイアログ表示
            dialogFragment.show(getSupportFragmentManager(),"OrderConfirmDialogFragment");
        }
    }
}
