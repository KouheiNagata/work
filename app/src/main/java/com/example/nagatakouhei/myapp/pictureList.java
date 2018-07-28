package com.example.nagatakouhei.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class pictureList extends Activity implements AdapterView.OnItemClickListener{

    private ArrayList<File> prePictureList;
    private ArrayList<Map<String, Object>> pictureList = new ArrayList<Map<String, Object>>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prePictureList = new ArrayList<File>();


        // SDカードにアクセス
            File file = new  File("/storage/emulated/0/");//SDカードにアクセス
            searchPictureFile(file);

            for(File f :prePictureList){
                Map data = new HashMap();
                data.put("thumbnail","");
                data.put("fileName","title : "+getFileName(f.getName()));
                data.put("fileSize","size : "+String.valueOf(f.length()));
                pictureList.add(data);
            }

            SimpleAdapter simpleAdapter = new SimpleAdapter(
                this,
                pictureList,
                R.layout.list_item,
                new String[]{"img","fileName","fileSize"},
                new int[]{R.id.thumbnail,R.id.fileName,R.id.fileSize}
                );

            ListView listView =(ListView)findViewById(R.id.listView);
            listView.setAdapter(simpleAdapter);
            listView.setOnItemClickListener(this);
    }

    public void onClick(View view){
        Log.d("test","画面呼び出し");
        Intent intent = new Intent(this, picture.class);
        startActivity(intent);
    }

    // 指定したパスの中から jpegファイルを取得する
    public void searchPictureFile(File f) {
        if (f.isDirectory()){
            File[] files =f.listFiles();

            for(File file: files){
                searchPictureFile(file);
            }
        } else {
            if(f.getName().endsWith("jpeg") || f.getName().endsWith("JPEG")){
                prePictureList.add(f);
            }
        }
    }

    // ファイル名から拡張子を除いた文字列を取得する
    public static String getFileName(String fileName) {
        String newName;

        int lastPosition = fileName.lastIndexOf('.');
        if (lastPosition > 0) {
            newName = fileName.substring(0, lastPosition);
        } else {
            newName = fileName;
        }
        return newName;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
