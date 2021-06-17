package com.java.utilsserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GetData {
    public static String readTxtFile(String filePath) {
        try {
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                ArrayList list = new ArrayList();
                String alEach = null;
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    list.add(lineTxt);
                }
                for (int i = 0; i < list.size(); i++) {
                    alEach = (String) list.get(i);
                }
                read.close();
                return alEach;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String argv[]) {
        String filePath = "E:\\新建文件夹\\1.txt";
//      "res/";
        readTxtFile(filePath);

    }


}
