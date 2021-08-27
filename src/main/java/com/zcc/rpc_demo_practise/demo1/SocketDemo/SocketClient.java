package com.zcc.rpc_demo_practise.demo1.SocketDemo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author zcc
 * @ClassName SocketClient
 * @description
 * @date 2021/8/27 16:52
 * @Version 1.0
 */

public class SocketClient {
    public static void main(String[] args) throws InterruptedException {
        String ip = "127.0.0.1";
        int port = 8080;
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;

        try {
            Socket client = new Socket(ip,port);
            System.out.println("client 发起连接----");


            String msg = "hello world ----------------------！";
            // 客户端发送消息
            outputStream = new ObjectOutputStream(client.getOutputStream());
            outputStream.writeUTF(msg);
            System.out.println("client 发送msg --->" + msg);

//            //客户端接收消息
//            inputStream = new ObjectInputStream(client.getInputStream());
//            //byte[] bytes = new byte[inputStream.available()];
//            String utf = inputStream.readUTF();
//            System.out.println("接收到server的消息--->:" + utf);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
