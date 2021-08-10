package com.zcc.thread_practise.JUC.AQS.abstractTemplate;

public class HouseOne extends HouseTemplate {

    protected HouseOne(String name) {
        super(name);
    }

    @Override
    protected void buildDoor() {
        System.out.println(name +"的门要采用防盗门");
    }

    @Override
    protected void buildWindow() {
        System.out.println(name +"的窗户要面向北方");
    }

    @Override
    protected void buildWall() {
        System.out.println(name +"的墙要用大理石建造");
    }

    @Override
    protected void buidlBase() {
        System.out.println(name +"的地基使用钢铁地基");
    }
}
