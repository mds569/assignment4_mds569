package com.example.assignment4_mds569;

import java.util.ArrayList;

public class Asteroid {

    // Store location and radius of the Asteroid
    // Use normalized coordinates for position (0.0 - 1.0)
    private double x, y, radius, angle;
    private ArrayList<Double> xPoints;
    private ArrayList<Double> yPoints;

    private int numPoints;

    public Asteroid(){
        // Set instance variables
        this.x = Math.random();
        this.y = Math.random();
        this.radius = (0.05 + Math.random() * (0.10 - 0.05));
        this.angle = 0;
        createPolygon();
    }

    public double getX() {return this.x;}

    public double getY() {return this.y;}

    public double getRadius() {return this.radius;}

    public double getAngle() {return this.angle;}

    public double[] getxPoints() {return this.xPoints.stream().mapToDouble(Double::doubleValue).toArray();}

    public double[] getyPoints() {return this.yPoints.stream().mapToDouble(Double::doubleValue).toArray();}

    public int getNumPoints() {return this.numPoints;}

    public void createPolygon(){
        this.xPoints = new ArrayList<>();
        this.yPoints = new ArrayList<>();
        // Determine number of sections to create
        int sections = (int) (4 + Math.random() * 5);
        this.numPoints = sections;
        for (int i = 0; i < sections; i++){
            double angle = (2 * Math.PI / sections) * i;
            double rad = this.radius * (0.1 + Math.random());
            double xVal = this.x + rad * Math.cos(angle);
            double yVal = this.y + rad * Math.sin(angle);

            xVal = Math.min(1.0, Math.max(0.0, xVal));
            yVal = Math.min(1.0, Math.max(0.0, yVal));

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
    }

    public void setY(double newY){
        this.y = newY;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public void setAngle(double angle){
        this.angle = angle;
    }
}
