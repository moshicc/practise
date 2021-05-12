package com.zcc.util;

import java.util.Date;

/**
 * @author zcc
 * @ClassName DateUtil
 * @description
 * @date 2021/5/12 17:33
 * @Version 1.0
 */

public class DateUtil {

    public static int calLastedTime(Date startDate) {
        long a = new Date().getTime();
        long b = startDate.getTime();
        int c = (int) ((a - b) / 1000);
        return c;
    }
}
