package com.example.assignment4_mds569;

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
        model.moveAsteroids();
        //model.spinAsteroids();
    }
}
