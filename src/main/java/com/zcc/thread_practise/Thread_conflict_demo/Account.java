package com.zcc.thread_practise.Thread_conflict_demo;

/**
 * @author zcc
 * @ClassName Account
 * @description
 * @date 2021/5/14 13:53
 * @Version 1.0
 */

public class Account {
    private String num;	//账号
    private double cash; //余额

    public Account(String num, double cash) {
        this.num = num;
        this.cash = cash;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}

