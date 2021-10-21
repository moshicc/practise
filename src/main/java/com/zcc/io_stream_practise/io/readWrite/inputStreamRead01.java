package com.zcc.io_stream_practise.io.readWrite;

import java.io.*;

/**
 * @author zcc
 * @ClassName inputStreamRead01
 * @description 用FileInputStream 读取字节流，再用InputStreamRead 把字节按照格式转为Read,然后再用BufferRead转为字符流
 *
 * @date 2021/10/19 9:30
 * @Version 1.0
 */

public class inputStreamRead01 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        inputStreamReadTest2();
        System.out.println((System.currentTimeMillis() - start) + "ms");
    }

    //因为默认用uft-8编码格式读取字节流
    private static void bufferReadTest1() {
        //当apple.txt为utf-8格式时，能正常输出中文。如果改为其他编码则不能正确输出中文（默认为utf-8）
        String filePath = "E:\\f\\apple.txt";
        FileReader fileReader = null;
        BufferedReader br = null;
        try{
            fileReader= new FileReader(filePath);
            br = new BufferedReader(fileReader);
           String context = br.readLine();
            //System.out.println("读取内容为：" + context);
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //用inputStream读取，使用InputStreamRead 用指定编码，把stream转为Read
    private static void inputStreamReadTest1() {
        String filePath = "E:\\f\\log.txt";
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;//处理流

        try {
            fis = new FileInputStream(filePath);
            //把读取的字节以指定格式转为read
            isr = new InputStreamReader(fis,"utf-8");
            br = new BufferedReader(isr);
            String s = br.readLine();
           System.out.println("读取的内容为：" + s);
        }catch (IOException e) {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    //利用缓冲流 测试提高效率
    private static void inputStreamReadTest2() {
        String filePath = "E:\\f\\log.txt";
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;//处理流
        char[] chars = new char[256];

        try {
            fis = new FileInputStream(filePath);
            //把读取的字节以指定格式转为read
            isr = new InputStreamReader(fis,"utf-8");
            br = new BufferedReader(isr);
            int index = br.read(chars);
            String s = new String(chars,0,index);
           System.out.println("读取的内容为：" + s);
        }catch (IOException e) {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
