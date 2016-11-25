package com.odde.emersonsgame.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by kevde on 11/25/2016.
 */
public class Player {
    private static final String NORMAL = "Normal";
    public static final String SUPERSPEED = "SuperSpeed";
    private ArrayList<Damage> damages;
    private String speed;
    private int score;
    private String name;

    public Player() {
        this.name = "DEFAULT";
        this.score = 0;
        this.damages = new ArrayList<>();
        this.speed = Player.NORMAL;
    }

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.damages = new ArrayList<>();
        this.speed = Player.NORMAL;
    }

    public int getPosition() {
        return score - (int) damages.stream().filter((damage) -> damage.isUsed()).count();
    }

    public String getSpeed() {
        return speed;
    }

    public int getDamage() {
        return (int) damages.stream().count();
    }

    public String getName() {
        return name;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public void includeDiceResult(Integer diceResult) {
        score = getScoreFromResult(diceResult);
        Optional<Damage> unusedDamage = Optional.of(new Damage());
        if(unusedDamage.isPresent()) {
            unusedDamage.get().use();
        }
        if (!Objects.equals(this.speed, NORMAL))  {
            damages.add(new Damage());
        }
    }

    public int getScoreFromResult(Integer diceResult) {
        return (Objects.equals(this.speed, NORMAL)) ? getNormalScore(diceResult) : getSuperSpeedScore(diceResult);
    }

    private int getSuperSpeedScore(Integer diceResult) {
        return diceResult;
    }

    public int getNormalScore(Integer diceResult) {
        return (diceResult%2 == 1) ? 1 : 2;
    }

    public Player withScore(int score) {
        this.score = score;
        return this;
    }

    public Player withSpeed(String speed) {
        this.setSpeed(speed);
        return this;
    }

    public Player withDamage(Damage damage) {
        this.damages.add(damage);
        return this;
    }
}
