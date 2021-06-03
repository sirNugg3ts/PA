package oval.iu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import oval.logica.Figura;


public class RootPane extends Pane {
    Ellipse ellipse;

    Figura figura;

    public RootPane(Figura figura){
        this.figura = figura;
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
            figura.setP1(e.getX(),e.getY());
            figura.setP2(e.getX(),e.getY());
            figura.setRGB(Math.random(),Math.random(),Math.random());

            atualiza();
        });
        this.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                figura.setP2(mouseEvent.getX(),mouseEvent.getY());
                atualiza();
            }
        });

        this.setOnMouseDragged((e) -> {
            figura.setP2(e.getX(),e.getY());
            atualiza();
        });
    }

    void atualiza(){
        if (ellipse == null || figura == null) return;
        ellipse.setCenterX(figura.getCX());
        ellipse.setCenterY(figura.getCY());
        ellipse.setRadiusX(figura.getLargura()/2);
        ellipse.setRadiusY(figura.getAltura()/2);
        ellipse.setFill(Color.color(figura.getR(),figura.getG(),figura.getB()));

    }

}
