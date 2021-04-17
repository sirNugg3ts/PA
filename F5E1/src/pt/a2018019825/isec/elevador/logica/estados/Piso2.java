package pt.a2018019825.isec.elevador.logica.estados;

import pt.a2018019825.isec.elevador.logica.Situacao;
import pt.a2018019825.isec.elevador.logica.dados.Elevador;

public class Piso2 extends EstadoAdapter {
    public Piso2(Elevador elevador) {
        super(elevador);
        elevador.recorda("Piso2");
    }

    @Override
    public IEstado desce() {
        return new Piso1(elevador);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.Piso2;
    }
}
