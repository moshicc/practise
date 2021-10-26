package com.zcc.netty.test1.nettyServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import javax.net.ssl.SSLException;
import java.security.cert.CertificateException;

/**
 * @author zcc
 * @ClassName EchoServer
 * @description  https://blog.csdn.net/weixin_37068368/article/details/80092442
 * @date 2021/9/8 15:20
 * @Version 1.0
 */

public class EchoServer {

    static final boolean SSL = System.getProperty("ssl") != null;
    static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));

    public static void main(String[] args) throws CertificateException, SSLException {
        System.out.println("EchoServer.Main start");

        // Configure SSL.
        final SslContext sslCtx;
        if (SSL) {
            SelfSignedCertificate ssc = new SelfSignedCertificate();
            sslCtx = SslContextBuilder.forServer(ssc.certificate(), ssc.privateKey()).build();
        } else {
            sslCtx = null;
        }

        // Configure the server.
        /*步骤
         * 创建一个ServerBootstrap b实例用来配置启动服务器
         * b.group指定NioEventLoopGroup来接收处理新连接
         * b.channel指定通道类型
         * b.option设置一些参数
         * b.handler设置日志记录
         * b.childHandler指定连接请求，后续调用的channelHandler
         * b.bind设置绑定的端口
         * b.sync阻塞直至启动服务
         */

        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    //.option(ChannelOption.SO_BACKLOG, 100)
                    //.handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline p = socketChannel.pipeline();
                            if (sslCtx != null) {
                                p.addLast(sslCtx.newHandler(socketChannel.alloc()));
                            }
                            //TODO
//                            p.addLast(new MessageDecoder());
//                            p.addLast(new MessageEecoder());
//                            p.addLast(new EchoServerHandler());
                        }
                    });

            //start server
            ChannelFuture f = b.bind(PORT).sync();
            System.out.println("EchoServer.Main ServerBootstrap配置启动完成");

            //wait until the server socket is closed
            f.channel().closeFuture().sync();
            System.out.println("EchoServer.Main end");
        } catch (Exception e) {
        // Shut down all event loops to terminate all threads.
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();

        }

    }
}
