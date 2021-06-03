package oval;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;



public class RootPane extends Pane {
    Ellipse ellipse;

    public RootPane(){
      criaLayout();
      registaListeners();
    }

    void criaLayout(){
        ellipse = new Ellipse(100,100,80,50);
        ellipse.setFill(Color.GREEN);
        this.getChildren().add(ellipse);
    }

    void registaListeners(){
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                ellipse.setCenterX(e.getX());
                ellipse.setCenterY(e.getY());
        });
    }

}
