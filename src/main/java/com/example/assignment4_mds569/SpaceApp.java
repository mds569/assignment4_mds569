package com.example.assignment4_mds569;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SpaceApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        MainUI root = new MainUI();

        Scene scene = new Scene(root);
        stage.setTitle("CMPT 381 Assignment 4: Multiple Views, Transforms and Selection - mds569");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}