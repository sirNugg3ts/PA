package pt.a2018019825.f8e1;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        RootPane root = new RootPane(stage);
        Scene scene = new Scene(root,800,600);
        stage.setScene(scene);
        stage.setMinHeight(200);
        stage.setMinWidth(200);
        stage.setTitle("Ex 1");

        stage.show();
    }


}

