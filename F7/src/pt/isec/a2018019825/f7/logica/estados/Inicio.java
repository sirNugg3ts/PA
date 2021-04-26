package pt.isec.a2018019825.f7.logica.estados;

import pt.isec.a2018019825.f7.logica.Situacao;
import pt.isec.a2018019825.f7.logica.dados.Jogo;

public class Inicio extends EstadoAdapter{

    public Inicio(Jogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado comeca() {
        jogo.iniciaJogo();
        jogo.addLog("Vou iniciar jogo\n");
        return new EsperarAposta(jogo);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.Inicio;
    }
}
