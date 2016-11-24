package com.odde.emersonsgame.model;

public class Player {
    private String name;

    public Player() {
        this(null);
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
