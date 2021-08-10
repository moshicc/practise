package com.zcc.thread_practise.JUC.AQS.abstractTemplate;

public class HouseTwo extends HouseTemplate {
    protected HouseTwo(String name) {
        super(name);
    }

    @Override
    protected void buildDoor() {
        System.out.println(name +"的门要采用木头门");
    }

    @Override
    protected void buildWindow() {
        System.out.println(name +"的窗子要向南");
    }

    @Override
    protected void buildWall() {
        System.out.println(name +"的墙使用透明玻璃制造");
    }

    @Override
    protected void buidlBase() {
        System.out.println(name +"的地基使用花岗岩地基");
    }
}
