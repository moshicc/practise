package com.zcc.rpc_demo_practise.demo1.rpc_client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author zcc
 * @ClassName ClientServiceProxyFactory
 * @description RPC客户端代理工厂（内含socket通信）
 * @date 2021/6/21 15:19
 * @Version 1.0
 */

public class ClientServiceProxyFactory {

    public static Object getClientService(Class interfaceClazz) {
        return Proxy.newProxyInstance(interfaceClazz.getClassLoader(), new Class[]{interfaceClazz},
                (proxy, method, args) -> getRPCResult(method, args));
    }

    /**
     * 通过socket远程连接server调用服务端实现类，并返回结果
     * @param method 代理的方法
     * @param args 代理方法参数
     * @return 远程调用返回结果
     */
    private static Object getRPCResult(Method method, Object[] args) {
        Object back = null;
        String[] path = getPath();

        //默认ip：127.0.0.1
        String ip = "217.0.0.1";
        int port = 80;
        if (null != path) {
            System.out.println(Arrays.asList(path));
            ip = path[0];
            try {
                port = Integer.parseInt(path[1]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        ObjectOutputStream objectOutStream = null;
        Socket client;
        try {
            //创建socket连接
            client = new Socket(ip, port);

            objectOutStream = new ObjectOutputStream(client.getOutputStream());
            objectOutStream.writeUTF(method.getName());
            objectOutStream.writeObject(method.getParameterTypes());
            objectOutStream.writeObject(args);

            try (ObjectInputStream objInStream = new ObjectInputStream(client.getInputStream())) {
                back = objInStream.readObject();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return back;
    }

    /**
     * 根据客户端Path注解获取所发送的ip+端口信息
     * @return ip+端口信息String[]
     */
    private static String[] getPath() {

        try {
            Method method = RPCClient.class.getDeclaredMethod("sendMsg", String.class);
            Path path = method.getDeclaredAnnotation(Path.class);
            //为了简化，假设ip 端口格式合法，暂不做格式校验
            String ipAndPort = path.ipAndPort();
            return ipAndPort.split(":");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

}
