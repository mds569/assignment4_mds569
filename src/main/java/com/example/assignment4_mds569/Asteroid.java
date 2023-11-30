package com.example.assignment4_mds569;

import java.util.ArrayList;
import java.util.Collections;

public class Asteroid {

    // Store location and radius of the Asteroid
    // Use normalized coordinates for position (0.0 - 1.0)
    private double x, y, radius, angle;
    private double xVelocity, yVelocity, aVelocity;
    private ArrayList<Double> xPoints;
    private ArrayList<Double> yPoints;

    private int numPoints;

    public Asteroid(){
        // Set instance variables
        this.x = Math.random();
        this.y = Math.random();
        this.radius = (0.05 + Math.random() * (0.10 - 0.05));
        this.angle = 0;
        this.xVelocity = ((-0.006) + Math.random() * (0.006 - (-0.006)));
        this.yVelocity = ((-0.006) + Math.random() * (0.006 - (-0.006)));
        this.aVelocity = ((-0.006) + Math.random() * (0.006 - (-0.006)));
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

    public void setxVelocity(double xVelocity){
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(double yVelocity){
        this.yVelocity = yVelocity;
    }

    public void setaVelocity(double aVelocity){
        this.aVelocity = aVelocity;
    }

    public void increasexVelocity(){
        // Get the furthest left and right points of the Asteroid
        double furthestLeft = Collections.min(this.xPoints);
        double furthestRight = Collections.max(this.xPoints);
        if (furthestLeft > 1.0){
            // Move the Asteroid back to the left side of the screen
            for (int i = 0; i < this.xPoints.size(); i++){
                this.xPoints.set(i, this.xPoints.get(i) - 1.0);
            }
        }
        else if (furthestRight < 0.0){
            // Move the Asteroid back to the right side of the screen
            for (int i = 0; i < this.xPoints.size(); i++){
                this.xPoints.set(i, this.xPoints.get(i) + 1.0);
            }
        }
        else {
            for (int i = 0; i < this.xPoints.size(); i++){
                this.xPoints.set(i, this.xPoints.get(i) + this.xVelocity);
            }
        }
    }

    public void increaseyVelocity(){
        // Get the furthest up and bottom points of the Asteroid
        double furthestUp = Collections.min(this.yPoints);
        double furthestDown = Collections.max(this.yPoints);
        if (furthestUp > 1.0){
            // Move the Asteroid back to the top of the screen
            for (int i = 0; i < this.yPoints.size(); i++){
                this.yPoints.set(i, this.yPoints.get(i) - 1.0);
            }
        }
        else if (furthestDown < 0.0){
            // Move the Asteroid back to the bottom of the screen
            for (int i = 0; i < this.yPoints.size(); i++){
                this.yPoints.set(i, this.yPoints.get(i) + 1.0);
            }
        }
        else {
            for (int i = 0; i < this.yPoints.size(); i++){
                this.yPoints.set(i, this.yPoints.get(i) + this.yVelocity);
            }
        }
    }

    public void increaseXandYVelocities(){
        // Get the furthest left, right, top, and bottom points of the Asteroid
        double furthestLeft = Collections.min(this.xPoints);
        double furthestRight = Collections.max(this.xPoints);
        double furthestTop = Collections.min(this.yPoints);
        double furthestBottom = Collections.max(this.yPoints);

        // Wrap around for x-axis
        if (furthestLeft > 1.0) {
            for (int i = 0; i < this.xPoints.size(); i++) {
                this.xPoints.set(i, this.xPoints.get(i) - 1.0);
            }
        } else if (furthestRight < 0.0) {
            for (int i = 0; i < this.xPoints.size(); i++) {
                this.xPoints.set(i, this.xPoints.get(i) + 1.0);
            }
        }

        // Wrap around for y-axis
        if (furthestTop > 1.0) {
            for (int i = 0; i < this.yPoints.size(); i++) {
                this.yPoints.set(i, this.yPoints.get(i) - 1.0);
            }
        } else if (furthestBottom < 0.0) {
            for (int i = 0; i < this.yPoints.size(); i++) {
                this.yPoints.set(i, this.yPoints.get(i) + 1.0);
            }
        }

        // Update points
        for (int i = 0; i < this.xPoints.size(); i++) {
            this.xPoints.set(i, this.xPoints.get(i) + this.xVelocity);
        }

        for (int i = 0; i < this.yPoints.size(); i++) {
            this.yPoints.set(i, this.yPoints.get(i) + this.yVelocity);
        }
    }

    public void increaseaVelocity() {
        this.angle += aVelocity;
    }
}
