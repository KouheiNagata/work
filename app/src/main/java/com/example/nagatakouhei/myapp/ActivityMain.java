package com.example.nagatakouhei.myapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityMain extends AppCompatActivity {

    /**
     * アクティビティ生成時に呼ばれる
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // レイアウトからリストビューを取得
        ListView listView = (ListView)findViewById(R.id.listView);

        // リストビューに表示する要素を設定
        ArrayList<ListItem> listItems = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);  // 今回はサンプルなのでデフォルトのAndroid Iconを利用
            ListItem item = new ListItem(bmp, "sample text No. " + String.valueOf(i),0);
            listItems.add(item);
        }

        // 出力結果をリストビューに表示
        ListAdapter adapter = new ListAdapter(this, R.layout.list_item, listItems);
        listView.setAdapter(adapter);
    }
}
