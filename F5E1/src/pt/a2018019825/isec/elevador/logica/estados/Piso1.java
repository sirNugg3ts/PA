package pt.a2018019825.isec.elevador.logica.estados;

import pt.a2018019825.isec.elevador.logica.Situacao;
import pt.a2018019825.isec.elevador.logica.dados.Elevador;

public class Piso1 extends EstadoAdapter {
    public Piso1(Elevador elevador) {
        super(elevador);
        elevador.recorda("Piso1");
    }

    @Override
    public IEstado sobe() {
        elevador.recorda("Vou subir");
        if(Math.random()< 0.4)
            return new Avariado(elevador,this);
        return new Piso2(elevador);
    }

    @Override
    public IEstado desce() {
        elevador.recorda("Vou descer");
        if(Math.random()< 0.4)
            return new Avariado(elevador,this);
        return new RC(elevador);
    }



    @Override
    public Situacao getSituacao() {
        return Situacao.Piso1;
    }
}
