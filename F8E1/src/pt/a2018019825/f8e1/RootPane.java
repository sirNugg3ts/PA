package pt.a2018019825.f8e1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class RootPane extends BorderPane {
    Stage stage;

    int nrGreen,nrBlue;

    Button btnGreen,btnBlue;
    Label lblGreen,lblBlue;

    public RootPane(Stage stage) {
        this.stage = stage;
        nrGreen = 0;
        nrBlue = 0;
        createLayout();
        registerListener();
        changeBackground(this,Color.RED);
    }

    void changeBackground(Region node, Color color){
        node.setBackground(new Background(new BackgroundFill(color,CornerRadii.EMPTY,Insets.EMPTY))
        );
    }

    private void createLayout() {
        btnBlue = new Button("Azul");
        btnGreen = new Button("Verde");
        HBox toolBar = new HBox();
        toolBar.getChildren().addAll(btnBlue,btnGreen);
        toolBar.setAlignment(Pos.CENTER);
        changeBackground(toolBar,Color.DARKGRAY);
        toolBar.setPadding(new Insets(10));
        toolBar.setSpacing(10);
        this.setTop(toolBar);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        for (int i=0;i<5;i++){
            for (int j = 0; j < 5; j++) {
                Pane pane = new Pane();
                pane.setPrefSize(50,50);
                changeBackground(pane,Color.ANTIQUEWHITE);
                grid.add(pane,i,j);
                pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Pane pane = (Pane) mouseEvent.getTarget();
                        changeBackground(pane,Color.BLACK);
                    }
                });
            }
        }
        grid.setAlignment(Pos.CENTER);
        this.setCenter(grid);


        lblGreen = new Label("#Green");
        lblBlue = new Label("#Blue");
        AnchorPane labels = new AnchorPane();
        labels.getChildren().addAll(lblGreen,lblBlue);

        AnchorPane.setLeftAnchor(lblGreen,10.0);
        AnchorPane.setBottomAnchor(lblGreen,10.0);
        AnchorPane.setBottomAnchor(lblBlue,10.0);
        AnchorPane.setRightAnchor(lblBlue,10.0);

        this.setBottom(labels);
    }

    private void registerListener(){
        btnBlue.setOnAction(new ProcBtnBlue());
        btnGreen.setOnAction(new ProcBtnGreen());
    }

    class ProcBtnBlue implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            changeBackground(RootPane.this,Color.BLUE);
            nrBlue++;
            updateLabels();
        }
    }

    void updateLabels(){
        lblBlue.setText("#Blue: " + nrBlue);
        lblGreen.setText("#Green: " + nrGreen);
    }

    class ProcBtnGreen implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            changeBackground(RootPane.this,Color.GREEN);
            nrGreen++;
            updateLabels();
        }
    }
}
