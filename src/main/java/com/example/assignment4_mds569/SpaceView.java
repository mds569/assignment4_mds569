package com.example.assignment4_mds569;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;

public class SpaceView extends StackPane implements Subscriber {
    private InteractionModel iModel;
    private SpaceModel model;

    public Canvas myCanvas;
    public GraphicsContext graphicsContext;

    public SpaceView(double size) {
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
        System.out.println("Draw");
    }

    public void setiModel(InteractionModel iModel) {
        this.iModel = iModel;
    }

    public void setModel(SpaceModel model) {
        this.model = model;
    }
}
