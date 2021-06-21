package com.zcc.rpc_demo_practise.demo1.rpc_client;

import com.zcc.rpc_demo_practise.demo1.rpc_server.ServerService;

/**
 * @author zcc
 * @ClassName RPCClient
 * @description RPC 客户端
 * @date 2021/6/21 15:18
 * @Version 1.0
 */

public class RPCClient {

    public static void main(String[] args) {
        sendMsg("aaa");
        sendMsg("bbb");
        sendMsg("ccc");
    }

    @Path(ipAndPort = "127.0.0.1:6060")
    private static void sendMsg(String msg) {
        ServerService clientService = (ServerService) ClientServiceProxyFactory.getClientService(ServerService.class);
        System.out.println("key:" + msg +", value:" + clientService.get(msg) );
    }
}
