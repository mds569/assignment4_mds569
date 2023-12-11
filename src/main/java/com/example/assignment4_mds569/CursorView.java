package com.example.assignment4_mds569;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class CursorView extends StackPane implements Subscriber {
    private double cursorX;
    private double cursorY;

    protected InteractionModel iModel;
    protected SpaceModel model;

    public double canvasSize;
    public double spaceViewSize;

    public Canvas myCanvas;
    public GraphicsContext graphicsContext;

    public CursorView(double size, double spaceViewSize){
        this.canvasSize = size;
        this.spaceViewSize = spaceViewSize;
        myCanvas = new Canvas(size, size);
        graphicsContext = myCanvas.getGraphicsContext2D();
        this.setStyle("-fx-background-color: black;");
        this.getChildren().addAll(myCanvas);
    }

    public void setCursorPosition(double x, double y){
        // Normalize coordinates from SpaceView
        this.cursorX = x / spaceViewSize;
        this.cursorY = y / spaceViewSize;
        System.out.println("Moved " + cursorX + " " + cursorY);
    }


    public void draw() {
        graphicsContext.clearRect(0, 0, getWidth(), getHeight());

        setCursorPosition(iModel.getCursorX(), iModel.getCursorY());

        double zoomX = this.cursorX * canvasSize;
        double zoomY = this.cursorY * canvasSize;

        graphicsContext.save();

        // Translate to center of zoom location and scale
        graphicsContext.translate((getWidth() - canvasSize) / 2 - zoomX, (getHeight() - canvasSize) / 2 - zoomY);
        graphicsContext.scale(2.0, 2.0);

        // Draw Stars
        graphicsContext.setFill(Color.WHITE);
        for (Star star : model.getStars()) {
            graphicsContext.fillOval(star.getX() * canvasSize, star.getY() * canvasSize, star.getRadius(), star.getRadius());
        }

        // Draw Asteroids
        graphicsContext.setFill(Color.GRAY);
        for (Asteroid asteroid : model.getAsteroids()) {
            graphicsContext.save();
            double[] xPoints = asteroid.getxPoints();
            double[] yPoints = asteroid.getyPoints();

            graphicsContext.translate(asteroid.getX() * canvasSize, asteroid.getY() * canvasSize);
            graphicsContext.rotate(asteroid.getAngle());
            graphicsContext.scale(canvasSize, canvasSize);
            graphicsContext.fillPolygon(xPoints, yPoints, asteroid.getNumPoints());
            graphicsContext.setStroke(Color.WHITE);
            graphicsContext.setLineWidth(0.003);
            graphicsContext.strokePolygon(xPoints, yPoints, asteroid.getNumPoints());
            graphicsContext.restore();
        }

        graphicsContext.restore();
    }

    @Override
    public void getNotification(String chnl) {
        switch (chnl){
            case "create", "delete", "update", "selection" -> {
                draw();
            }
        }
    }

    public void setiModel(InteractionModel iModel) {
        this.iModel = iModel;
    }

    public void setModel(SpaceModel model) {
        this.model = model;
    }
}
