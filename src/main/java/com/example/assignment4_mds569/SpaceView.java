package com.example.assignment4_mds569;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class SpaceView extends StackPane implements Subscriber {
    private InteractionModel iModel;
    private SpaceModel model;

    private double canvasSize;

    public Canvas myCanvas;
    public GraphicsContext graphicsContext;

    public SpaceView(double size) {
        this.canvasSize = size;
        myCanvas = new Canvas(size, size);
        graphicsContext = myCanvas.getGraphicsContext2D();
        this.setStyle("-fx-background-color: black;");
        this.getChildren().addAll(myCanvas);
    }

    @Override
    public void getNotification(String chnl) {
        switch (chnl){
            case "create" -> {
                draw();
                System.out.println("Create");
            }
            case "delete" -> {
                draw();
                System.out.println("Delete");
            }
            case "update" -> {
                draw();
                System.out.println("Update");
            }
            case "selection" -> {
                draw();
                System.out.println("Selection");
            }
        }
    }

    public void draw() {
        graphicsContext.clearRect(0, 0, canvasSize, canvasSize);
        graphicsContext.setFill(Color.WHITE);
        for(Star star : model.getStars()){
            graphicsContext.fillOval(star.getX(), star.getY(), star.getRadius(),star.getRadius());
        }
        graphicsContext.setFill(Color.GRAY);
        for (Asteroid asteroid : model.getAsteroids()){
            graphicsContext.fillOval(asteroid.getX(), asteroid.getY(), asteroid.getRadius(), asteroid.getRadius());
        }
        System.out.println("Draw");
    }

    public void setiModel(InteractionModel iModel) {
        this.iModel = iModel;
    }

    public void setModel(SpaceModel model) {
        this.model = model;
    }
}
