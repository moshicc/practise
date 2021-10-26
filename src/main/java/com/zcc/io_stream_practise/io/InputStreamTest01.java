package com.zcc.io_stream_practise.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author zcc
 * @ClassName InputStreamTest01
 * @description 把数据从 目标文件中读取出来
 * @date 2021/10/18 9:58
 * @Version 1.0
 */

public class InputStreamTest01 {
    public static void main(String[] args) {
        fileInput2();

    }

    public static void fileInput(){
        String srcPath = "e:/f/apple.txt";
        FileInputStream fis = null;
        int contxt;
        try {
            //构建一个inputStream对象
            fis = new FileInputStream(srcPath);
            //每次读取一个字节(单个字节读取)
            while ((contxt = fis.read()) != -1) {
                //System.out.println(contxt);
                System.out.print((char) contxt);
            }
        }catch (Exception e) {
            
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileInput2(){
        String srcPath = "e:/f/apple.txt";
        FileInputStream fis = null;
        int index;
        try {
            //构建一个inputStream对象
            fis = new FileInputStream(srcPath);
            //缓冲区
            byte[] buf = new byte[8];
            //每次读取8个字节, index 代表实际读取的字节数，比如最后一次buf可能读不满，就需要取buf中0到index这么长的数了。
            while ((index = fis.read(buf)) != -1) {
                System.out.print(new String(buf,0,index));
            }
        }catch (Exception e) {

        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
