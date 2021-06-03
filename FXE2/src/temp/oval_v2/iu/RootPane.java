package temp.oval_v2.iu;

import com.sun.javafx.iio.gif.GIFImageLoaderFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import temp.oval_v2.logica.Desenho;



public class RootPane extends BorderPane {

    Desenho desenho;
    AreaDesenho areaDesenho = new AreaDesenho(desenho);
    HBox toolBar;
    Button btnApagaUltimo,btnApagaTudo;
    Button btnRed,btnGreen,btnBlue,btnRandom;

    public RootPane(Desenho desenho){
        this.desenho = desenho;
      criaLayout();
      registaListeners();
      atualiza();
    }

    private void atualiza() {
        areaDesenho.atualiza();
    }

    ChangeListener procSize = new ChangeListener() {
        @Override
        public void changed(ObservableValue observableValue, Object o, Object t1) {
            areaDesenho.alteraDimensoes(RootPane.this.getWidth(),RootPane.this.getHeight());

        }
    };

    private void registaListeners() {
        widthProperty().addListener(procSize);
        heightProperty().addListener(procSize);
        areaDesenho.registaListeners();
        btnApagaUltimo.setOnAction(e -> {
            desenho.apagaUltima();
            areaDesenho.atualiza();
        });
        btnApagaTudo.setOnAction(e -> {
            desenho.apagaTudo();
            areaDesenho.atualiza();
        });

        btnRed.setOnAction(e -> {desenho.setRGB(1,0,0);atualizaBotaoAtivo();});
        btnBlue.setOnAction(e -> {desenho.setRGB(0,0,1);atualizaBotaoAtivo();});
        btnGreen.setOnAction(e -> {desenho.setRGB(0,1,0);atualizaBotaoAtivo();});
        btnRandom.setOnAction(e -> {desenho.setRGB(Math.random(),Math.random(),Math.random());atualizaBotaoAtivo();});


    }

    void atualizaBotaoAtivo(){
        Border border = new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT));
        double r = desenho.getR();
        double g = desenho.getG();
        double b = desenho.getB();
        btnRed.setBorder(r > 0 && g==0 && b == 0 ? border : null);
        btnGreen.setBorder(g > 0 && r==0 && b == 0 ? border : null);
        btnBlue.setBorder(b > 0 && r==0 && g == 0 ? border : null);
        btnRandom.setBorder(r * g != 0 || r*b != 0 || g*b!=0 ? border : null);
    }

    void criaLayout(){
        toolBar = new HBox();
        btnApagaTudo = new Button("Apaga tudo");
        btnApagaUltimo = new Button("Apaga Ultimo");

        btnBlue = new Button();
        btnRed = new Button();
        btnGreen = new Button();
        btnRandom = new Button("?");

        btnRed.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        btnBlue.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        btnGreen.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        btnRed.setPrefSize(30,30);
        btnBlue.setPrefSize(30,30);
        btnGreen.setPrefSize(30,30);
        btnRandom.setPrefSize(30,30);


        toolBar.getChildren().addAll(btnRed,btnGreen,btnBlue,btnRandom,new Line(0,0,0,30),btnApagaUltimo,btnApagaTudo);
        toolBar.setAlignment(Pos.CENTER);
        toolBar.setSpacing(5);
        toolBar.setPadding(new Insets(10));
        this.setTop(toolBar);

      areaDesenho = new AreaDesenho(desenho);
      this.setCenter(areaDesenho);
    }


}

