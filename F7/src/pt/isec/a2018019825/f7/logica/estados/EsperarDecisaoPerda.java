package pt.isec.a2018019825.f7.logica.estados;

import pt.isec.a2018019825.f7.logica.Situacao;
import pt.isec.a2018019825.f7.logica.dados.Jogo;

public class EsperarDecisaoPerda extends EstadoAdapter{
    public EsperarDecisaoPerda(Jogo jogo) {
        super(jogo);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.EsperarDecisaoPerda;
    }
}
