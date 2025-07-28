package com.micah.springapi.dto;

import jakarta.validation.constraints.*;

public class EvaluationRequest {
    @Min(1) @Max(100)
    private int level;

    @Min(1)
    private int hp;

    @Min(0)
    private int attack;

    @Min(0)
    private int defense;

    @Min(0)
    private int speed;

    // Getters and setters
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }

    public int getAttack() { return attack; }
    public void setAttack(int attack) { this.attack = attack; }

    public int getDefense() { return defense; }
    public void setDefense(int defense) { this.defense = defense; }

    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }
}