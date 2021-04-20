package pt.a2018019825.isec.elevador.logica.estados;

import pt.a2018019825.isec.elevador.logica.Situacao;
import pt.a2018019825.isec.elevador.logica.dados.Elevador;

public abstract class EstadoAdapter implements IEstado {

    protected Elevador elevador;

    protected EstadoAdapter(Elevador elevador){
        this.elevador = elevador;
    }

    @Override
    public IEstado sobe() {
        return this;
    }

    @Override
    public IEstado desce() {
        return this;
    }

    @Override
    public IEstado insereChave() {
        return this;
    }
}

