package pt.isec.a2018019825.f7.logica.estados;

import pt.isec.a2018019825.f7.logica.Situacao;
import pt.isec.a2018019825.f7.logica.TipoBola;
import pt.isec.a2018019825.f7.logica.dados.Jogo;

public class EsperarDecisaoPerda extends EstadoAdapter{
    public EsperarDecisaoPerda(Jogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado tira2BolasDoSaco() {
        TipoBola b1 = jogo.tiraBolaDoSaco();
        TipoBola b2 = jogo.tiraBolaDoSaco();
        if (b1==TipoBola.Preta)
            jogo.devolveBolas(1,TipoBola.Preta);
        else if(b1 == TipoBola.Branca)
            jogo.retiraBranca();
        else
            return new FimJogo(jogo);

        if (b2==TipoBola.Preta)
            jogo.devolveBolas(1,TipoBola.Preta);
        else if(b2 == TipoBola.Branca)
            jogo.retiraBranca();
        else
            return new FimJogo(jogo);

        if (jogo.isSacoVazio())
            return new FimJogo(jogo);

        return new EsperarAposta(jogo);
    }

    @Override
    public IEstado removeBolaBrancadaPilha() {
        if(!jogo.perdeBranca())
            return this;
        jogo.retiraBranca();
        if (jogo.isSacoVazio())
            return new FimJogo(jogo);
        return new EsperarAposta(jogo);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.EsperarDecisaoPerda;
    }
}
