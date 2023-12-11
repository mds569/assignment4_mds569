package com.example.assignment4_mds569;

import javafx.scene.input.MouseEvent;

public class SpaceController {

    private SpaceModel model;
    private InteractionModel iModel;

    public void setModel(SpaceModel newModel){
        this.model = newModel;
    }

    public void setiModel(InteractionModel newIModel){
        this.iModel = newIModel;
    }

    public void handleAnimationTick() {
        iModel.setWorldRotation(iModel.getWorldRotation() + iModel.getRotationSpeed());
        model.spinAsteroids();
        model.moveAsteroids();
    }

    // Called when mouse is moved, notifies the interaction model of new coordinates
    public void handleMouseMove(MouseEvent mouseEvent){
        iModel.updateCursorLocation(mouseEvent.getX(), mouseEvent.getY());
    }
}
