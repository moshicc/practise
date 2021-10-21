package com.zcc.io_stream_practise.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zcc
 * @ClassName FileInputStreamTest01
 * @description 复制文件:将指定目录下的文件，复制到另一个地方，测试用缓冲的效率
 * @date 2021/10/19 11:09
 * @Version 1.0
 */

public class FileInputStreamTest01 {
    public static void main(String[] args) {
        String filePath = "E:\\f\\test.jpg";
        String destPath = "E:\\f\\test_1.jpg";
        long start = System.currentTimeMillis();
        inputStream02(filePath, destPath);
        System.out.println((System.currentTimeMillis() -start) + "ms");

    }

    //不使用缓冲流 复制文件  4000+ ms
    private static void inputStream01(String filePath, String destPath) {
        //step1：输入流读取
        //step2：输出流写入（边读取，边写入）
        //FileInputStream fis = null;
        //FileOutputStream fos = null;

        try(FileInputStream fis = new FileInputStream(filePath);FileOutputStream fos = new FileOutputStream(destPath);) {
            int context;
            while ((context = fis.read()) != -1) {
                fos.write(context);
            }
            System.out.println("文件复制完成！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //使用缓冲流 复制文件 40ms 左右
    private static void inputStream02(String filePath, String destPath) {
        //step1：输入流读取
        //step2：输出流写入（边读取，边写入）
        //FileInputStream fis = null;
        //FileOutputStream fos = null;

        try(FileInputStream fis = new FileInputStream(filePath);FileOutputStream fos = new FileOutputStream(destPath);) {
            int len;
            byte[] context = new byte[256];
            while ((len = fis.read(context)) != -1) {
                fos.write(context, 0, len);
            }
            System.out.println("文件复制完成！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
