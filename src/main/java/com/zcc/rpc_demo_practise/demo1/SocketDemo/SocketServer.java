package com.zcc.rpc_demo_practise.demo1.SocketDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author zcc
 * @ClassName SocketServer
 * @description
 * @date 2021/8/27 16:52
 * @Version 1.0
 * https://blog.csdn.net/wcuuchina/article/details/99741209
 */

public class SocketServer {
    public static void main(String[] args) {
        String address = "";
        int port = 8080;

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务端启动---->port:" + port);

            while (true) { //保持服务端运行
                final Socket accept = serverSocket.accept();
                System.out.println("收到来自：" +accept.getRemoteSocketAddress());

                ObjectInputStream inputStream =  null;
                ObjectOutputStream outputStream = null;

                InputStream stream = accept.getInputStream();
                inputStream = new ObjectInputStream(stream);
                String data = inputStream.readUTF();
                //int available = inputStream.available();
                //byte[] bytes = new byte[available];
                //bytes转String
                System.out.println("客户端对服务端说--->msg: "+ data );

                String msgToClinet =" hello client !";


                outputStream = new ObjectOutputStream(accept.getOutputStream());
               // outputStream.writeObject(msgToClinet);
                outputStream.writeUTF(msgToClinet);
                System.out.println("server  返回信息--->" + msgToClinet);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != serverSocket) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
