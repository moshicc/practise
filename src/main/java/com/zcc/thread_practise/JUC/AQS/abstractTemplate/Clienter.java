package com.zcc.thread_practise.JUC.AQS.abstractTemplate;

public class Clienter {

    public static void main(String[] args) {
        HouseTemplate houseOne = new HouseOne("小明");
        HouseTemplate houseTow = new HouseTwo("小红");

        houseOne.buildHouse();
        houseTow.buildHouse();
    }



}
