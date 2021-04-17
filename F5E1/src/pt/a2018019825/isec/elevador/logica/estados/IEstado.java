package pt.a2018019825.isec.elevador.logica.estados;

import pt.a2018019825.isec.elevador.logica.Situacao;

public interface IEstado {
    IEstado sobe();

    IEstado desce();

    Situacao getSituacao();
}
