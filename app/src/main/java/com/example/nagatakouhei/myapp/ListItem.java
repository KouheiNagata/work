package com.example.nagatakouhei.myapp;

import android.graphics.Bitmap;

public class ListItem {
    private Bitmap mThumbnail;
    private String mTitle;
    private int mFileSize;


    public ListItem() {};

    public ListItem(Bitmap thumbnail, String title, int fileSize){
        mThumbnail = thumbnail;
        mTitle = title;
        mFileSize = fileSize;
    }

    /**
     * thumbnailを取得
     * @return
     */
    public Bitmap getThumbnail(){
        return mThumbnail;
    }

    /**
     * titleを取得
     * @return
     */
    public String getTitle(){
        return mTitle;
    }

    /**
     * filesizeを取得
     * @return
     */
    public int getFileSize(){
        return mFileSize;
    }

    /**
     * thumbnailを設定
     * @param thumbnail
     */
    public void setThumbnail(Bitmap thumbnail){
        mThumbnail = thumbnail;
    }

    /**
     * titleを設定
     * @param title
     */
    public void setTitle(String title){
        mTitle = title;

    }

    /**
     * filesizeを設定
     * @param fileSize
     */
    public void setFileSize(int fileSize){
        mFileSize = fileSize;

    }


}
