package com.example.assignment4_mds569;

public class Star {

    // Store location and radius of the Star
    // Use normalized coordinates for position (0.0 - 1.0)
    private double x, y, radius;

    public Star(double x, double y, double radius){
        // Set instance variables
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {return this.x;}

    public double getY() {return this.y;}

    public double getRadius() {return this.radius;}

    public void setPosition(double newX, double newY){
        this.x = newX;
        this.y = newY;
    }

    public void setX(double newX){
        this.x = newX;
    }

    public void setY(double newY){
        this.y = newY;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }
}
