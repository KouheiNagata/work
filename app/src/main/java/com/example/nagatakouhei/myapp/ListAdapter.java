package com.example.nagatakouhei.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<ListItem> {
    private int mResource;
    private List<ListItem> mItems;
    private LayoutInflater mInflater;

    public ListAdapter(Context context, int resource, List<ListItem> items){
        super(context, resource, items);

        mResource = resource;
        mItems = items;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view;

        if (convertView != null) {
            view = convertView;
        } else {
            view = mInflater.inflate(mResource, null);
        }

        // リストビューに表示する要素を取得
        ListItem item = mItems.get(position);

        // サムネイル画像を取得
        ImageView thumbnail = (ImageView)view.findViewById(R.id.thumbnail);
        thumbnail.setImageBitmap(item.getThumbnail());

        // タイトルを取得
        TextView title = (TextView)view.findViewById(R.id.fileName);
        title.setText(item.getTitle());

        // ファイルサイズを取得
        TextView fileSize = (TextView)view.findViewById(R.id.fileSize);

        return view;
    }

}
