package com.zcc.rpc_demo_practise.demo1.rpc_client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zcc
 * @ClassName Path
 * @description 自定义注解Path，用于指定要连接的服务端ip+port
 * @date 2021/6/21 15:52
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Path {
    String ipAndPort() default "127.0.0.1:80";
}
