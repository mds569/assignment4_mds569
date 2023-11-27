package com.example.assignment4_mds569;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

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
            graphicsContext.fillOval(star.getX()*canvasSize, star.getY()*canvasSize, star.getRadius(), star.getRadius());
        }
        graphicsContext.setFill(Color.GRAY);
        /*for (Asteroid asteroid : model.getAsteroids()){
            for (Double coord : asteroid.getxPoints()){
                coord = coord * canvasSize;
            }
            for (Double coord : asteroid.getyPoints()){
                coord = coord * canvasSize;
            }
            //graphicsContext.fillOval(asteroid.getX()*canvasSize, asteroid.getY()*canvasSize, asteroid.getRadius(), asteroid.getRadius());
            graphicsContext.fillPolygon(asteroid.getxPoints(), asteroid.getyPoints(), asteroid.getNumPoints());
        }*/

        for (Asteroid asteroid : model.getAsteroids()) {
            ArrayList<Double> xPoints = asteroid.getxPoints();
            ArrayList<Double> yPoints = asteroid.getyPoints();

            System.out.println("Original xPoints: " + xPoints.toString());
            System.out.println("Original yPoints: " + yPoints.toString());

            for (int i = 0; i < xPoints.size(); i++){
                xPoints.set(i, xPoints.get(i) * canvasSize);
            }
            for (int i = 0; i < yPoints.size(); i++){
                yPoints.set(i, yPoints.get(i) * canvasSize);
            }

            //System.out.println("Scaled xPoints: " + xPoints.toString());
            //System.out.println("Scaled yPoints: " + yPoints.toString());


            graphicsContext.fillPolygon(
                    xPoints.stream().mapToDouble(Double::doubleValue).toArray(),
                    yPoints.stream().mapToDouble(Double::doubleValue).toArray(),
                    asteroid.getNumPoints()
            );
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
