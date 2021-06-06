package ex3_v2.logica;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class DesenhoObs {
    public static final String DESENHO = "Desenho";
    public static final String TIPOFIGURA = "TipoFigura";
    public static final String COR = "Cor";
    Desenho desenho;
    PropertyChangeSupport pcs;

    public DesenhoObs() {
        desenho = new Desenho();
        pcs = new PropertyChangeSupport(this);
    }

    public void addObserver(String property,PropertyChangeListener listener){
        pcs.addPropertyChangeListener(property,listener);
    }

    public void iniciar(double x, double y){
        desenho.iniciar(x,y);
        pcs.firePropertyChange(DESENHO,0,1);
    }

    public void setFiguraSelecionada(Figura.TipoFigura figuraSelecionada) {
desenho.setFiguraSelecionada(figuraSelecionada);
    pcs.firePropertyChange(TIPOFIGURA,0,1);}

    public Figura.TipoFigura getFiguraSelecionada() {
         return desenho.getFiguraSelecionada();
    }

    public void setRGB(double r, double g, double b){
        desenho.setRGB(r,g,b);
        pcs.firePropertyChange(COR,0,1);
    }

    public double getR() {
        return desenho.getR();
    }

    public double getG() {
        return desenho.getG();
    }

    public double getB() {
        return desenho.getB();
    }

    public void altera(double x, double y){
       desenho.altera(x,y);
       pcs.firePropertyChange(DESENHO,0,1);
    }

    public void termina(double x,double y){
       desenho.termina(x,y);
        pcs.firePropertyChange(DESENHO,0,1);

    }

    public List<Figura> getLista(){
        return desenho.getLista();
    }

    public Figura getAtual() {
        return desenho.getAtual();
    }

    public void apagaUltima(){
       desenho.apagaUltima();
        pcs.firePropertyChange(DESENHO,0,1);

    }

    public void apagaTudo(){
       desenho.apagaTudo();
        pcs.firePropertyChange(DESENHO,0,1);

    }
}
