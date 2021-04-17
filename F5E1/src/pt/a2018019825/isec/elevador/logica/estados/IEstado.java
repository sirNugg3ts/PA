package pt.a2018019825.isec.elevador.logica.estados;

public interface IEstado {
    IEstado sobe();

    IEstado desce();

    Situacao getSituacao();
}
