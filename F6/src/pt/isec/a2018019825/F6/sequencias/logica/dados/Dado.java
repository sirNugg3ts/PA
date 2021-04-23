package pt.isec.a2018019825.F6.sequencias.logica.dados;

public class Dado {
    private int valor = 0;

    void lanca(){
        valor = (int)(Math.random()* 6) + 1;
    }

    int getValor(){
        return valor;
    }

    @Override
    public String toString(){
        return "" + valor;
    }
}
