package pt.a2018019825.isec.elevador.logica;

import pt.a2018019825.isec.elevador.logica.dados.Elevador;
import pt.a2018019825.isec.elevador.logica.estados.IEstado;
import pt.a2018019825.isec.elevador.logica.estados.RC;

public class MaquinaEstados {
    IEstado atual;
    Elevador elevador;
    public MaquinaEstados() {
        atual = new RC(elevador);
        elevador = new Elevador();
    }

    public void sobe() {

        atual = atual.sobe();
    }

    public String getHistorico(){
        return elevador.toString();
    }

    public void desce() {
        atual = atual.desce();
    }

    public Situacao getSituacaoAtual(){
        return atual.getSituacao();
    }

    public void insereChave(){
        atual=atual.insereChave();
    }
}
