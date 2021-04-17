package pt.a2018019825.isec.elevador.logica;

import pt.a2018019825.isec.elevador.logica.estados.IEstado;
import pt.a2018019825.isec.elevador.logica.estados.RC;

public class MaquinaEstados {
    IEstado atual;

    public MaquinaEstados() {
        atual = new RC();
    }

    public void sobe() {
        atual = atual.sobe();
    }

    public void desce() {
        atual = atual.desce();
    }

    public IEstado getSituacaoAtual(){
        return atual;
    }
}
