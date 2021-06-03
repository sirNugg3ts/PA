package oval;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oval.iu.RootPane;
import oval.logica.Figura;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Figura figura = new Figura();
        RootPane root = new RootPane(figura);
        Scene scene = new Scene(root,800,600);
        stage.setScene(scene);
        stage.setTitle("Ex2");
        stage.setMinWidth(300);stage.setMinHeight(300);
        stage.show();
    }
}

