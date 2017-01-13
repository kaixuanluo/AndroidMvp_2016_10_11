package com.example.admin.androidmvp_2016_10_11.utils;

import android.content.Context;

import java.io.File;


/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/24 16:55 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/24 16:55 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class AssertUtil {

    public static File getAssertFile (Context context, String assertName) {
//        File fSk = new File(SkinFileUtils.getSkinDir(context));
//        fSk.mkdir();
//        File f = new File(fSk.getAbsolutePath() , assertName);
//        if (!f.exists()) try {
//            InputStream is = context.getAssets().open(assertName);
//            int size = is.available();
//            byte[] buffer = new byte[size];
//            is.read(buffer);
//            is.close();
//
//
//            FileOutputStream fos = new FileOutputStream(f);
//            fos.write(buffer);
//            fos.close();
//        } catch (Exception e) { throw new RuntimeException(e); }

        File f = null;
//
//        String[] skinFiles = new String[0];
//        try {
//            skinFiles = context.getAssets().list(SkinConfig.SKIN_DIR_NAME);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for (String fileName : skinFiles) {
//            File file = new File(SkinFileUtils.getSkinDir(context), fileName);
//            if (!file.exists()) {
//                SkinFileUtils.copySkinAssetsToDir(context, fileName, SkinFileUtils.getSkinDir(context));
//            }
//
//            if (assertName.equals(fileName)) {
//                f = file;
//            }
//        }
//
        return f;
    }

}
