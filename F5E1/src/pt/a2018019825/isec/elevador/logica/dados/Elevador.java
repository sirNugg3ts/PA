package pt.a2018019825.isec.elevador.logica.dados;

import java.util.ArrayList;

public class Elevador {
    ArrayList<String> historico;

    public Elevador(){
        historico = new ArrayList<String>();
    }

    public void recorda(String evolucao){
        historico.add(evolucao);
    }

    @Override
    public String toString() {
        return historico.toString();
    }
}
