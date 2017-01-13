package com.example.admin.androidmvp_2016_10_11.utils;

import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/24 16:58 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/24 16:58 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class FileUtil {
    private static String SDPATH = "";

    /**
     * 获取到sd卡的根目录，并以String形式返回
     *
     * @return
     */
    public static String getSDCardPath() {
        SDPATH = Environment.getExternalStorageDirectory() + "/";
        return SDPATH;
    }

    /**
     * 创建文件或文件夹
     *
     * @param fileName
     *            文件名或问文件夹名
     */
    public static void createFileDir(String fileName) {
        File file = new File(getSDCardPath() + fileName);
        if (fileName.indexOf(".") != -1) {
            // 说明包含，即使创建文件, 返回值为-1就说明不包含.,即使文件
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("创建了文件");
        } else {
            // 创建文件夹
            file.mkdir();
            System.out.println("创建了文件夹");
        }

    }
}
