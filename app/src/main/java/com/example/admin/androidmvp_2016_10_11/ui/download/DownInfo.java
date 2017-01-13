package com.example.admin.androidmvp_2016_10_11.ui.download;

import java.io.File;

/**
 * apk下载请求数据基础类
 * Created by WZG on 2016/10/20.
 */

public class DownInfo {
    private String id;
    /*存储位置*/
    private File savePath;
    /*文件总长度*/
    private long countLength;
    /*下载长度*/
    private long readLength;

    String name;

    private HttpProgressOnNextListener listener;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public File getSavePath() {
        return savePath;
    }

    public void setSavePath(File savePath) {
        this.savePath = savePath;
    }

    public HttpProgressOnNextListener getListener() {
        return listener;
    }

    public void setListener(HttpProgressOnNextListener listener) {
        this.listener = listener;
    }

    public long getCountLength() {
        return countLength;
    }

    public void setCountLength(long countLength) {
        this.countLength = countLength;
    }

    public long getReadLength() {
        return readLength;
    }

    public void setReadLength(long readLength) {
        this.readLength = readLength;
    }
}
