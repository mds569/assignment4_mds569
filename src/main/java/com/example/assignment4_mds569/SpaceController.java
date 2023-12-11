package com.example.assignment4_mds569;

import javafx.scene.input.MouseEvent;

public class SpaceController {

    private SpaceModel model;
    private InteractionModel iModel;

    public enum State {SPIN_CHECKED, MOVE_CHECKED, BOTH_CHECKED, NO_CHECKED}

    State currentState;

    public SpaceController() {
        currentState = State.BOTH_CHECKED;
    }

    public void setModel(SpaceModel newModel){
        this.model = newModel;
    }

    public void setiModel(InteractionModel newIModel){
        this.iModel = newIModel;
    }

    // Whenever a box is checked/unchecked we will update the State
    public void updateState(boolean isMoveChecked, boolean isSpinChecked){
        if (isMoveChecked && isSpinChecked){
            currentState = State.BOTH_CHECKED;
        } else if (isMoveChecked) {
            currentState = State.MOVE_CHECKED;
        } else if (isSpinChecked) {
            currentState = State.SPIN_CHECKED;
        } else { currentState = State.NO_CHECKED;}
    }

    // Called every animation tick
    public void handleAnimationTick() {

        switch (currentState){
            case BOTH_CHECKED -> {
                iModel.setWorldRotation(iModel.getWorldRotation() + iModel.getRotationSpeed());
                model.spinAsteroids();
                model.moveAsteroids();
            }
            case MOVE_CHECKED -> {
                iModel.setWorldRotation(iModel.getWorldRotation() + iModel.getRotationSpeed());
                model.moveAsteroids();
            }
            case SPIN_CHECKED -> {
                iModel.setWorldRotation(iModel.getWorldRotation() + iModel.getRotationSpeed());
                model.spinAsteroids();
            }
            case NO_CHECKED -> iModel.setWorldRotation(iModel.getWorldRotation() + iModel.getRotationSpeed());
        }
    }

    // Called when mouse is moved, notifies the interaction model of new coordinates
    public void handleMouseMove(MouseEvent mouseEvent){
        iModel.updateCursorLocation(mouseEvent.getX(), mouseEvent.getY());
    }

    public void updateRotationSpeed(double newSpeed){
        iModel.setWorldRotationSpeed(newSpeed);
    }
}
