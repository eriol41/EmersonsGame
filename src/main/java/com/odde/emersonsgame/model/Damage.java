package com.odde.emersonsgame.model;

/**
 * Created by kevde on 11/25/2016.
 */
public class Damage {
    private boolean used;

    public Damage() {
        this.used = false;
    }

    public void use() {
        used = true;
    }

    public boolean isUsed() {
        return used;
    }
}
