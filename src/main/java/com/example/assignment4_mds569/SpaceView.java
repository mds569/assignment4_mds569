package com.example.assignment4_mds569;

import javafx.scene.layout.StackPane;

public class SpaceView extends StackPane implements Subscriber {
    private InteractionModel iModel;
    private SpaceModel model;
    @Override
    public void getNotification(String chnl) {

    }

    public void setiModel(InteractionModel iModel) {
        this.iModel = iModel;
    }

    public void setModel(SpaceModel model) {
        this.model = model;
    }
}
