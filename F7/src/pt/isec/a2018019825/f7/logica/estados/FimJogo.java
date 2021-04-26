package pt.isec.a2018019825.f7.logica.estados;

import pt.isec.a2018019825.f7.logica.Situacao;
import pt.isec.a2018019825.f7.logica.dados.Jogo;

public class FimJogo extends EstadoAdapter{
    public FimJogo(Jogo jogo) {
        super(jogo);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.FimJogo;
    }

    @Override
    public IEstado comeca() {
        jogo.iniciaJogo();
        return new EsperarAposta(jogo);
    }
}
