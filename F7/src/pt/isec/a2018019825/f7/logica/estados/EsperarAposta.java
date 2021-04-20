package pt.isec.a2018019825.f7.logica.estados;

import pt.isec.a2018019825.f7.logica.Situacao;
import pt.isec.a2018019825.f7.logica.TipoBola;
import pt.isec.a2018019825.f7.logica.dados.Jogo;

public class EsperarAposta extends EstadoAdapter{
    public EsperarAposta(Jogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado aposta(int nBolas) {
        if(!jogo.aposta(nBolas))
            return this;
        TipoBola bola = jogo.tiraBolaDoSaco();

        if (bola == TipoBola.Branca){
            //ganhou
            //retirar bolas do saco em igual numero da aposta
            //devolverbolas da aposta
            //acrescentar bola branca ganha
            //
            if(jogo.isSacoVazio())
                    return new FimJogo(jogo);
            return new EsperarAposta(jogo); //alternativa: return this;
        }
        //perdeu
        //
        jogo.perdeAposta();
        jogo.retiraPreta();
        //
        return new EsperarDecisaoPerda(jogo);

    }

    @Override
    public IEstado termina() {
        return new FimJogo(jogo);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.EsperarAposta;
    }
}
