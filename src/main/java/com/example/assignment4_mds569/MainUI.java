package com.example.assignment4_mds569;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainUI extends BorderPane {

    public MainUI(){
        // Create each class/element
        SpaceController controller = new SpaceController();
        SpaceView view = new SpaceView(800);
        SpaceModel model = new SpaceModel();
        InteractionModel iModel = new InteractionModel();
        PublishSubscribe publishSubscribe = new PublishSubscribe();
        SpaceView miniView = new SpaceView(200);
        CursorView cursorView = new CursorView(200, 800);
        ControlPanelView controlPanelView = new ControlPanelView();

        // Connect them properly
        controller.setModel(model);
        model.setPubSub(publishSubscribe);
        controller.setiModel(iModel);
        view.setiModel(iModel);
        view.setModel(model);
        miniView.setiModel(iModel);
        miniView.setModel(model);
        cursorView.setiModel(iModel);
        cursorView.setModel(model);
        iModel.setPubSub(publishSubscribe);

        // Set growth constraints
        //VBox.setVgrow(view, Priority.ALWAYS);

        // Create VBox for side panel
        VBox panel = new VBox();
        panel.setSpacing(5);
        panel.setStyle("-fx-border-color: #191919 #191919 transparent transparent; -fx-border-width: 2 5 0 0");
        panel.getChildren().addAll(miniView, cursorView, controlPanelView);
        panel.setMaxWidth(cursorView.getPrefWidth());

        // Create main application StackPane and set style
        StackPane main = new StackPane(view);
        this.setCenter(main);
        this.setLeft(panel);
        this.setStyle("-fx-base: #191919; -fx-background-color: #191919;");

        // Create PublishSubscribe channels
        publishSubscribe.createChannel("create");
        publishSubscribe.createChannel("delete");
        publishSubscribe.createChannel("update");
        publishSubscribe.createChannel("selection");

        // Ensure the main view is subscribed
        publishSubscribe.addSubscriber("create", view);
        publishSubscribe.addSubscriber("delete", view);
        publishSubscribe.addSubscriber("update", view);
        publishSubscribe.addSubscriber("selection", view);

        // Ensure the miniView is subscribed
        publishSubscribe.addSubscriber("create", miniView);
        publishSubscribe.addSubscriber("delete", miniView);
        publishSubscribe.addSubscriber("update", miniView);
        publishSubscribe.addSubscriber("selection", miniView);

        // Ensure the cursorView is subscribed
        publishSubscribe.addSubscriber("create", cursorView);
        publishSubscribe.addSubscriber("delete", cursorView);
        publishSubscribe.addSubscriber("update", cursorView);
        publishSubscribe.addSubscriber("selection", cursorView);

        // Create the stars and asteroids
        model.createInitialStars();

        for (int i = 0; i < 3; i++){
            model.createAsteroid();
        }

        // Set up AnimationTimer
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                controller.handleAnimationTick();
            }
        };
        timer.start();

        // Event routing
        view.setOnMouseMoved(controller::handleMouseMove);
        controlPanelView.getRotationSlider().valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldVal, Number newVal) {
                double speed = newVal.doubleValue();
                controller.updateRotationSpeed(speed);
            }
        });

        controlPanelView.getMovementCheckbox().selectedProperty().addListener((observableValue, oldVal, newVal) -> {
            controller.updateState(newVal, controlPanelView.getSpinCheckbox().isSelected());
        });

        controlPanelView.getSpinCheckbox().selectedProperty().addListener((observableValue, oldVal, newVal) -> {
            controller.updateState(controlPanelView.getMovementCheckbox().isSelected(), newVal);
        });


    }
}
