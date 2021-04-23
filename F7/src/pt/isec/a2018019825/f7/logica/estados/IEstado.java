package pt.isec.a2018019825.f7.logica.estados;

import pt.isec.a2018019825.f7.logica.Situacao;

public interface IEstado {

    IEstado comeca();
    IEstado aposta(int nBolas);
    IEstado tira2BolasDoSaco();
    IEstado removeBolaBrancadaPilha();
    IEstado termina();

    Situacao getSituacao();

}

