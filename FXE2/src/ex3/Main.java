package ex3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ex3.iu.RootPane;
import ex3.logica.Desenho;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Desenho desenho = new Desenho();
        RootPane root = new RootPane(desenho);
        Scene scene = new Scene(root,800,600);
        stage.setScene(scene);
        stage.setTitle("Ex3");
        stage.setMinWidth(300);stage.setMinHeight(300);
        stage.show();
    }
}

