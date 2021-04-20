package pt.a2018019825.isec.elevador.logica.estados;

import pt.a2018019825.isec.elevador.logica.Situacao;
import pt.a2018019825.isec.elevador.logica.dados.Elevador;

public class Avariado extends EstadoAdapter {
    IEstado anterior;

    protected Avariado(Elevador elevador, IEstado anterior) {
        super(elevador);
        this.anterior = anterior;
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.Avariado;
    }
}
