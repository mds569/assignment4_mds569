package com.example.assignment4_mds569;

import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class MainUI extends VBox {

    public MainUI(){
        SpaceController controller = new SpaceController();
        SpaceView view = new SpaceView();
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

        // Event routing
        //setOnKeyPressed(controller::handleKeyPressed);

        this.getChildren().addAll(view);
    }
}
