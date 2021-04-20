package pt.a2018019825.isec.elevador.logica.estados;

import pt.a2018019825.isec.elevador.logica.Situacao;
import pt.a2018019825.isec.elevador.logica.dados.Elevador;

public class Avariado extends EstadoAdapter {
    IEstado anterior;

    protected Avariado(Elevador elevador, IEstado anterior) {
        super(elevador);
        this.anterior = anterior;
        elevador.recorda("Avariado");
    }

    @Override
    public IEstado insereChave() {
        return anterior;
        //anterior.getClass().getConstructor(Elevador.class).newInstance(elevador);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.Avariado;
    }


}
