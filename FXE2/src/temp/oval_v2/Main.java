package temp.oval_v2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import temp.oval_v2.iu.RootPane;
import temp.oval_v2.logica.Desenho;
import temp.oval_v2.logica.Figura;

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
        stage.setTitle("Ex2");
        stage.setMinWidth(300);stage.setMinHeight(300);
        stage.show();
    }
}

