package com.example.assignment4_mds569;

public class InteractionModel {
    private PublishSubscribe pubSub;

    // Store the current world rotation along with it's rotation speed
    private double worldRotation;
    private double rotationSpeed;

    // Store the cursor x and y (based in the SpaceView)
    private double cursorX, cursorY;

    public InteractionModel(){
        this.worldRotation = 0.0;
        this.rotationSpeed = 0.5;
    }

    public void updateCursorLocation(double cursorX, double cursorY){
        this.cursorX = cursorX;
        this.cursorY = cursorY;
    }

    public double getCursorX() {return this.cursorX;}

    public double getCursorY() {return this.cursorY;}

    public void setWorldRotation(double worldRotation) {
        this.worldRotation = worldRotation;
        pubSub.publish("update");
    }

    public void setWorldRotationSpeed(double rotationSpeed){this.rotationSpeed = rotationSpeed;}

    public double getWorldRotation() {
        return worldRotation;
    }

    public double getRotationSpeed() {
        return rotationSpeed;
    }

    public void setPubSub(PublishSubscribe publishSubscribe) {
        this.pubSub = publishSubscribe;
    }

    // Behavior for selecting Asteroids
    public void selectAsteroid(double x, double y) {

    }
}
