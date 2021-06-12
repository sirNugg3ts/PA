package ex3_v3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ex3_v3.iu.RootPane;
import ex3_v3.logica.DesenhoObs;

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

        Stage stage2 = new Stage();
        RootPane2 root2 = new RootPane2(desenho);
        Scene scene2 = new Scene(root2,800,600);
        stage2.setScene(scene2);
        stage2.setTitle("Janela 2");
        stage2.show();
    }
}

class RootPane2 extends Pane {
    DesenhoObs desenho;
    public RootPane2(DesenhoObs desenho) {
        this.desenho = desenho;
        createLayout();
        registaListeners();
    }

    private void createLayout() {
    }

    private void registaListeners(){

    }
}

