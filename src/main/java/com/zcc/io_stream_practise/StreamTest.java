package com.zcc.io_stream_practise;

import java.io.*;

public class StreamTest {
    public static void main(String[] args) throws IOException {
        String path = "D:/zcc/test.txt";
        String input =  "D:/zcc/input.txt";
        String input2 =  "D:/zcc/input2.txt";
        //读取数据，输入流，inputStream
//        try (FileReader fileReader = new FileReader(input)) {
//            int ch = 0;
//            while ( (ch = fileReader.read()) != -1) {
//                // 每次读取的下一个值不为-1
//                System.out.print((char) ch);
//            }
//        }
        //从input.txt输入
        FileInputStream inputStream = new FileInputStream(input);
        byte[] buf= new byte[inputStream.available()];
        inputStream.read(buf);
        System.out.println(new String(buf));//String底层就是个字节数组
        inputStream.close();

        //输出到input2.txt
        FileOutputStream outputStream = new FileOutputStream(input2);
        outputStream.write(buf);
        outputStream.close();


//        try {
//            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream());
//            writer.write("张聪聪");
//            writer.flush();
//            writer.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
