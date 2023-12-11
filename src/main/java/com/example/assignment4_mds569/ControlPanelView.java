package com.example.assignment4_mds569;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class ControlPanelView extends VBox {

    // Store the elements of this widget
    private Label rotationLabel;
    private Slider rotationSlider;
    private CheckBox movementCheckbox;
    private CheckBox spinCheckbox;

    public ControlPanelView(){
        rotationLabel = new Label("Rotation Speed");
        rotationSlider = new Slider(0.0, 1.0, 0.5); // Min, Max, Starting Value
        movementCheckbox = new CheckBox("Asteroid Movement");
        movementCheckbox.setSelected(true);
        spinCheckbox = new CheckBox("Asteroid Spin");
        spinCheckbox.setSelected(true);

        // ADD EVENT HANDLERS IN MAINUI

        setSpacing(10);
        setPadding(new Insets(10));
        getChildren().addAll(rotationLabel, rotationSlider, movementCheckbox, spinCheckbox);
    }


    public Slider getRotationSlider() {return this.rotationSlider;}


    public CheckBox getMovementCheckbox(){
        return movementCheckbox;
    }


    public CheckBox getSpinCheckbox(){
        return spinCheckbox;
    }

}
