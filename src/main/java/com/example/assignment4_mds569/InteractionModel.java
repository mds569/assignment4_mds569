package com.example.assignment4_mds569;

public class InteractionModel {
    private PublishSubscribe pubSub;

    private double worldRotation;
    private double rotationSpeed;

    public InteractionModel(){
        this.worldRotation = 0.0;
        this.rotationSpeed = 0.5;
    }

    public void setWorldRotation(double worldRotation) {
        this.worldRotation = worldRotation;
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
}
