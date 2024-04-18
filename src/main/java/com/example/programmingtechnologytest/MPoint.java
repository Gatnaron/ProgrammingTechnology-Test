package com.example.programmingtechnologytest;

import javafx.scene.paint.Color;

public class MPoint {
    private String name;
    private double x;
    private double y;
    private Color color;
    private char symbol;

    public MPoint(String name, double x, double y, Color color, char symbol) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.color = color;
        this.symbol = symbol;
    }

    // Геттеры и сеттеры для всех полей

    public void setName(String name) {this.name = name;}

    public String getName() {
        return name;
    }

    public void setSymbol(char symbol) {this.symbol = symbol;}

    public char getSymbol() {
        return symbol;
    }
    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "point" + name + "{x=" + x + ", y=" + y + ", color=" + color.toString() + " " + symbol + "}";
    }
}
