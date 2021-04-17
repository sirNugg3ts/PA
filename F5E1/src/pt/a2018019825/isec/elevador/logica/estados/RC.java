package pt.a2018019825.isec.elevador.logica.estados;

import pt.a2018019825.isec.elevador.logica.Situacao;
import pt.a2018019825.isec.elevador.logica.dados.Elevador;

public class RC extends EstadoAdapter {
    public RC(Elevador elevador) {
        super(elevador);
        elevador.recorda("RC");
    }

    @Override
    public IEstado sobe() {
        return new Piso1(elevador);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.RC;
    }
}
