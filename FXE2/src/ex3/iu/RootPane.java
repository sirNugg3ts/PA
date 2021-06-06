package ex3.iu;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import ex3.logica.Desenho;
import ex3.logica.Figura;


public class RootPane extends BorderPane {

    Desenho desenho;
    AreaDesenho areaDesenho = new AreaDesenho(desenho);
    HBox toolBar;
    Button btnApagaUltimo,btnApagaTudo;
    Button btnRed,btnGreen,btnBlue,btnRandom;
    Button btnLinha,btnRetangulo,btnOval;

    public RootPane(Desenho desenho){
        this.desenho = desenho;
      criaLayout();
      registaListeners();
      atualizaBotaoCorAtivo();
      atualizaBotaoTipoAtivo();
    }

    ChangeListener procSize = new ChangeListener() {
        @Override
        public void changed(ObservableValue observableValue, Object o, Object t1) {
            areaDesenho.alteraDimensoes(RootPane.this.getWidth(), RootPane.this.getHeight());

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

        btnRed.setOnAction(e -> {desenho.setRGB(1,0,0);
            atualizaBotaoCorAtivo();});
        btnBlue.setOnAction(e -> {desenho.setRGB(0,0,1);
            atualizaBotaoCorAtivo();});
        btnGreen.setOnAction(e -> {desenho.setRGB(0,1,0);
            atualizaBotaoCorAtivo();});
        btnRandom.setOnAction(e -> {desenho.setRGB(Math.random(),Math.random(),Math.random());
            atualizaBotaoCorAtivo();});
        btnOval.setOnAction(e -> {desenho.setFiguraSelecionada(Figura.TipoFigura.OVAL);atualizaBotaoTipoAtivo();});
        btnLinha.setOnAction(e -> {desenho.setFiguraSelecionada(Figura.TipoFigura.LINHA);atualizaBotaoTipoAtivo();});
        btnRetangulo.setOnAction(e -> {desenho.setFiguraSelecionada(Figura.TipoFigura.RETANGULO);atualizaBotaoTipoAtivo();});

    }

    void atualizaBotaoCorAtivo(){
        Border border = new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT));
        double r = desenho.getR();
        double g = desenho.getG();
        double b = desenho.getB();
        btnRed.setBorder(r > 0 && g==0 && b == 0 ? border : null);
        btnGreen.setBorder(g > 0 && r==0 && b == 0 ? border : null);
        btnBlue.setBorder(b > 0 && r==0 && g == 0 ? border : null);
        btnRandom.setBorder(r * g != 0 || r*b != 0 || g*b!=0 ? border : null);
    }

    void atualizaBotaoTipoAtivo(){
        Border border = new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT));
       Figura.TipoFigura tipo = desenho.getFiguraSelecionada();
        btnLinha.setBorder(tipo == Figura.TipoFigura.LINHA ? border : null);
        btnOval.setBorder(tipo == Figura.TipoFigura.OVAL ? border : null);
        btnRetangulo.setBorder(tipo == Figura.TipoFigura.RETANGULO? border : null);
    }

    void criaLayout(){
        toolBar = new HBox();
        btnApagaTudo = new MyButton("Apaga tudo");
        btnApagaUltimo = new MyButton("Apaga Ultimo");

        btnBlue = new MyButton();
        btnRed = new MyButton();
        btnGreen = new MyButton();
        btnRandom = new MyButton("?");
        btnLinha = new MyButton();
        btnRetangulo = new MyButton();
        btnOval = new MyButton();

        btnRed.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        btnBlue.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        btnGreen.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        btnRetangulo.setGraphic(new Rectangle(0,0,20,20));
        btnLinha.setGraphic(new Line(0,0,20,20));
        btnOval.setGraphic(new Ellipse(0,0,10,10));


        toolBar.getChildren().addAll(btnRed,btnGreen,btnBlue,btnRandom,new Line(0,0,0,30),btnApagaUltimo,btnApagaTudo,btnOval,btnRetangulo,btnLinha);
        toolBar.setAlignment(Pos.CENTER);
        toolBar.setSpacing(5);
        toolBar.setPadding(new Insets(10));
        this.setTop(toolBar);

      areaDesenho = new AreaDesenho(desenho);
      this.setCenter(areaDesenho);
    }


}

class MyButton extends Button{
    public MyButton() {
        super();
        this.setPrefSize(30,30);
    }

    public MyButton(String s) {
        super(s);

    }
}

