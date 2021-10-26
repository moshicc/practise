package com.zcc.demo;

import java.io.*;

/**
 * @author zcc
 * @ClassName ReadUtils
 * @description
 * @date 2021/10/26 19:48
 * @Version 1.0
 */

public class ReadUtils {

    public static void main(String[] args) {
        String filePath =new ReadUtils().getClass().getClassLoader().getResource("input.txt").getPath();
        File file = new File(filePath);

        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String context = null;
            int lineCount = 0;
            while((context = br.readLine()) != null) {
                lineCount ++ ; //计数器，统计行数
                if (lineCount == 1) {
                    //第一行，获取工作时间
                    System.out.println("工作时间：" + context);
                } else {
                    System.out.println("第：" + lineCount + "行数据为：" + context);
                    //从第二行开始，每两行为一次申请
//                    for (int i = lineCount; ((i - 1) % 2) == 0; i++ ) {
//                        //得到2行数据，处理
//                        System.out.println("第" + lineCount + "行数据。");
//
//                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }


    }

    public static Order dueData(String context) {
        Order order = new Order();

        return order;
    }


}
