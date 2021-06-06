package ex3_v2;

import ex3_v2.logica.DesenhoObs;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ex3_v2.iu.RootPane;
import ex3_v2.logica.Desenho;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        DesenhoObs desenho = new DesenhoObs();
        RootPane root = new RootPane(desenho);
        Scene scene = new Scene(root,800,600);
        stage.setScene(scene);
        stage.setTitle("Ex3");
        stage.setMinWidth(300);stage.setMinHeight(300);
        stage.show();
    }
}

