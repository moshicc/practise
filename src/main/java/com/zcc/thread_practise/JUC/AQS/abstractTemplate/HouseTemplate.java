package com.zcc.thread_practise.JUC.AQS.abstractTemplate;

/**
 * AQS使用了模板模式，所谓的模板模式，通过一个例子来看-----以设计房子为例
 */
public abstract class HouseTemplate {
    protected HouseTemplate(String name) {
        this.name = name;
    }
    protected String name;

    protected abstract void buildDoor();

    protected abstract void buildWindow();

    protected abstract void buildWall();

    protected abstract void buidlBase();

    //公共逻辑

    public final void buildHouse(){
        buidlBase();
        buildWall();
        buildDoor();
        buildWindow();
    }

}
