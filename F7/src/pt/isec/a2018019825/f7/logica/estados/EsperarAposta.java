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
        jogo.addLog("Recebi uma aposta de " + nBolas + "\n");
        if(!jogo.aposta(nBolas))
            return this;
        TipoBola bola = jogo.tiraBolaDoSaco();

        if (bola == TipoBola.Branca){
            jogo.addLog("Saiu bola branca\n");
            //ganhou

            //acrescentar bola branca ganha
            jogo.ganhaBranca();

            //retirar bolas do saco em igual numero da aposta
            int nr_b=0;
            for(int i = 0;!jogo.isSacoVazio() && i<jogo.getAposta();i++){
                TipoBola b = jogo.tiraBolaDoSaco();
                if(b==TipoBola.Branca){
                    nr_b++;
                }else{
                    jogo.retiraPreta();
                }
            }
            jogo.devolveBolas(nr_b,TipoBola.Branca);
            //devolver bolas da aposta
            jogo.recuperaAposta();
            //

            if(jogo.isSacoVazio())
                    return new FimJogo(jogo);
            return new EsperarAposta(jogo); //alternativa: return this;
        }
        //perdeu
        //
        jogo.addLog("Saiu bola preta\n");
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
