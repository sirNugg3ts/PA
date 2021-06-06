package ex3.logica;

import java.util.ArrayList;
import java.util.List;

public class Desenho {
    double r,g,b;
    Figura.TipoFigura figuraSelecionada;
    Figura atual;
    ArrayList<Figura> lista;

    public Desenho() {
        this.lista = new ArrayList<>();
        figuraSelecionada = Figura.TipoFigura.LINHA;
    }

    public void iniciar(double x, double y){
        switch (figuraSelecionada){
            case LINHA -> atual = new Linha();
            case OVAL -> atual = new Oval();
            case RETANGULO -> atual = new Retangulo();
            default -> {
                atual = null;
                return;
            }
        }

        atual.setP1(x,y);
        atual.setP2(x,y);
        atual.setRGB(r,g,b);
    }

    public void setFiguraSelecionada(Figura.TipoFigura figuraSelecionada) {
        this.figuraSelecionada = figuraSelecionada;
    }

    public Figura.TipoFigura getFiguraSelecionada() {
        return figuraSelecionada;
    }

    public void setRGB(double r, double g, double b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public double getR() {
        return r;
    }

    public double getG() {
        return g;
    }

    public double getB() {
        return b;
    }

    public void altera(double x, double y){
        if (atual==null) return;
        atual.setP2(x,y);
    }

    public void termina(double x,double y){
        if (atual==null) return;
        atual.setP2(x,y);
        lista.add(atual);
        atual = null;
    }

    public List<Figura> getLista(){
        return lista;
    }

    public Figura getAtual() {
        return atual;
    }

    public void apagaUltima(){
        atual = null;
        if (lista.isEmpty())
            return;
        lista.remove(lista.size()-1);
    }

    public void apagaTudo(){
        lista.clear();
        atual = null;
    }
}
