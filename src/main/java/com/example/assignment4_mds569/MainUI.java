package com.example.assignment4_mds569;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class MainUI extends VBox {

    public MainUI(){
        SpaceController controller = new SpaceController();
        SpaceView view = new SpaceView(800);
        SpaceModel model = new SpaceModel();
        InteractionModel iModel = new InteractionModel();
        PublishSubscribe publishSubscribe = new PublishSubscribe();

        controller.setModel(model);
        model.setPubSub(publishSubscribe);
        controller.setiModel(iModel);
        view.setiModel(iModel);
        view.setModel(model);
        iModel.setPubSub(publishSubscribe);

        // Set growth constraints
        //VBox.setVgrow(view, Priority.ALWAYS);

        publishSubscribe.createChannel("create");
        publishSubscribe.createChannel("delete");
        publishSubscribe.createChannel("update");
        publishSubscribe.createChannel("selection");

        publishSubscribe.addSubscriber("create", view);
        publishSubscribe.addSubscriber("delete", view);
        publishSubscribe.addSubscriber("update", view);
        publishSubscribe.addSubscriber("selection", view);

        model.createInitialStars();

        for (int i = 0; i < 10; i++){
            model.createAsteroid();
        }

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                controller.handleAnimationTick();
            }
        };
        timer.start();

        // Event routing
        //setOnKeyPressed(controller::handleKeyPressed);

        this.getChildren().addAll(view);
    }
}
