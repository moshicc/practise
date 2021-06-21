package com.zcc.rpc_demo_practise.demo1.rpc_server;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zcc
 * @ClassName ServerServiceImpl
 * @description
 * @date 2021/6/21 16:21
 * @Version 1.0
 */

public class ServerServiceImpl implements ServerService {
    @Override
    public String get(Object key) {
        Map<String, Object> map = new HashMap<>();
        map.put("aaa","111");
        map.put("bbb", "222");
        map.put("ccc", new User("张三",18));
        Object obj = map.get(key);
        if (null == obj) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
//        if (obj instanceof Object) {
//            JSONObject json = new JSONObject();
//            json.put(obj.getClass().getName(), obj);
//            System.out.println("json:" + json.toJSONString());
//            return  json.toJSONString();
//        }
        return obj.toString();
    }
}
