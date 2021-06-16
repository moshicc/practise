package com.zcc.thread_practise.Thread_IO;

import com.zcc.util.DateUtil;

import java.io.*;
import java.util.Date;

/**
 * @author zcc
 * @ClassName CopyFile
 * @description
 * @date 2021/6/5 15:30
 * @Version 1.0
 */

public class CopyFile implements Runnable {
    private static File source = new File("E:\\log\\bd.mp4");
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run Thread:" + t.getName());
        //File source = new File("E:\\log\\bd.mp4");
        File dest = new File("E:\\log\\bd2.mp4");
        Date startTime = new Date();
        copyFileUsingFileStreams(source, dest);
        System.out.println("使用时间：" + DateUtil.calLastedTime(startTime) + "秒");

    }

    private void copyFileUsingFileStreams(File source, File dest) {
        Thread t = Thread.currentThread();
        System.out.println("current Thread:" + t.getName());
        InputStream input = null;
        OutputStream out = null;

        try {
            input = new FileInputStream(source);
            out = new FileOutputStream(dest);
            byte[] buf = new byte[512];
            int bytesRead;
            while(( bytesRead = input.read(buf) )!= -1) {
                out.write(buf, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
