package ex3_v2.iu;

import ex3_v2.logica.DesenhoObs;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import ex3_v2.logica.Desenho;
import ex3_v2.logica.Figura;

public class AreaDesenho extends Canvas {
    DesenhoObs desenho;

    public AreaDesenho(DesenhoObs desenho) {
        super(400, 400);
        this.desenho = desenho;
        desenho.addObserver(DesenhoObs.DESENHO, e-> {
            atualiza();
        });
    }

    void registaListeners() {
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            desenho.iniciar(e.getX(), e.getY());
            //atualiza();
        });

        this.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                desenho.termina(mouseEvent.getX(), mouseEvent.getY());
                //atualiza();
            }
        });

        this.setOnMouseDragged((e) -> {
            desenho.altera(e.getX(), e.getY());
            //atualiza();
        });
    }


    void clear(GraphicsContext gc) {
        gc.setFill(Color.rgb(233, 240, 200));
        gc.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    void atualiza() {
        if (desenho == null) return;
        GraphicsContext gc = this.getGraphicsContext2D();
        clear(gc);
        for (Figura figura: desenho.getLista()) {
            desenhaFigura(gc,figura);
        }
        if (desenho.getAtual()!=null)
            desenhaFigura(gc,desenho.getAtual());
    }

    void desenhaFigura(GraphicsContext gc, Figura figura){
        if (figura == null) return;
        gc.setFill(Color.color(figura.getR(), figura.getG(), figura.getB()));
        gc.setStroke(Color.color(figura.getR(), figura.getG(), figura.getB()).darker());
        gc.setLineWidth(5);
        switch (figura.getTipoFigura()){
            case LINHA:
                gc.strokeLine(figura.getX1(),figura.getY1(),figura.getX2(),figura.getY2());
                break;
            case OVAL:
                gc.fillOval(figura.getX1(), figura.getY1(), figura.getLargura(), figura.getAltura());
                gc.strokeOval(figura.getX1(), figura.getY1(), figura.getLargura(), figura.getAltura());
                break;
            case RETANGULO:
                gc.fillRect(figura.getX1(), figura.getY1(), figura.getLargura(), figura.getAltura());
                gc.strokeRect(figura.getX1(), figura.getY1(), figura.getLargura(), figura.getAltura());
                break;
        }
    }

    public void alteraDimensoes(double width, double height) {
        setWidth(width);
        setHeight(height);
        atualiza();
    }
}
