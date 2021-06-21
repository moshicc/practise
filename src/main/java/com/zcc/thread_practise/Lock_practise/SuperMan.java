package com.zcc.thread_practise.Lock_practise;

/**
 * @author zcc
 * @ClassName SuperMan
 * @description
 * @date 2021/6/5 14:27
 * @Version 1.0
 */

public class SuperMan {
    private String name;
    private int energy;

    public SuperMan(String name) {
        this.name = name;
        this.energy = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
