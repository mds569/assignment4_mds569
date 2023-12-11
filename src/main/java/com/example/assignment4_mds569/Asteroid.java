package com.example.assignment4_mds569;

import java.util.ArrayList;
import java.util.Collections;

public class Asteroid {

    // Store location and radius of the Asteroid
    // Use normalized coordinates for position (0.0 - 1.0)
    private double x, y, radius, angle;
    private double xVelocity, yVelocity;

    private int aVelocity;
    private ArrayList<Double> xPoints;
    private ArrayList<Double> yPoints;

    private int numPoints;

    public Asteroid(){
        // Set instance variables
        this.xPoints = new ArrayList<>();
        this.yPoints = new ArrayList<>();
        this.x = Math.random();
        this.y = Math.random();
        this.radius = /*(0.05 + Math.random() * (0.10 - 0.05))*/0.1;
        this.angle = 0;
        this.xVelocity = ((-0.006) + Math.random() * (0.006 - (-0.006)));
        this.yVelocity = ((-0.006) + Math.random() * (0.006 - (-0.006)));
        this.aVelocity = (int) (1 + Math.random() * 10);
        createPolygon();
    }

    public double getX() {return this.x;}

    public double getY() {return this.y;}

    public double getRadius() {return this.radius;}

    public double getAngle() {return this.angle;}

    public double getxVelocity() {return this.xVelocity;}

    public double getyVelocity() {return this.yVelocity;}

    public double getaVelocity() {return this.aVelocity;}

    public double[] getxPoints() {return this.xPoints.stream().mapToDouble(Double::doubleValue).toArray();}

    public double[] getyPoints() {return this.yPoints.stream().mapToDouble(Double::doubleValue).toArray();}

    public int getNumPoints() {return this.numPoints;}

    public void createPolygon(){
        // Determine number of sections to create
        int sections = (int) (4 + Math.random() * 5);
        this.numPoints = sections;
        for (int i = 0; i < sections; i++){
            double angle = (2 * Math.PI / sections) * i;
            double rad = /*this.radius - 0.02 + Math.random() * 0.04*/((Math.random() * (0.13 - 0.07)) + 0.07);
            double xVal = /*this.x*/ + rad * Math.cos(angle);
            double yVal = /*this.y*/ + rad * Math.sin(angle);

            xPoints.add(xVal);
            yPoints.add(yVal);
        }
    }

    public void setPosition(double newX, double newY){
        this.x = newX;
        this.y = newY;
    }

    public void setX(double newX){
        this.x = newX;
        for (int i = 0; i < numPoints; i++){
            this.xPoints.set(i, (this.xPoints.get(i) - this.x + newX));
        }
    }

    public void setY(double newY){
        this.y = newY;
        for (int i = 0; i < numPoints; i++){
            this.yPoints.set(i, (this.yPoints.get(i) - this.y + newY));
        }
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public void setAngle(double angle){
        this.angle = angle;
    }

    public void setxVelocity(double xVelocity){
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(double yVelocity){
        this.yVelocity = yVelocity;
    }

    public void setaVelocity(int aVelocity){
        this.aVelocity = aVelocity;
    }


    public void moveAsteroid(){
        // Update points
        setX(getX() + getxVelocity());

        // Wrap around logic for x-axis
        if (getX() < 0.0) {
            setX(1.0 + getX());
        } else if (getX() > 1.0) {
            setX(getX() - 1.0);
        }

        // Update points
        setY(getY() + getyVelocity());

        // Wrap around logic for y-axis
        if (getY() < 0.0) {
            setY(1.0 + getY());
        } else if (getY() > 1.0) {
            setY(getY() - 1.0);
        }

    }

    public void spinAsteroid() {
        this.angle += aVelocity;
        if (this.angle >= 360) this.angle = 0;
    }
}
