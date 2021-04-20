package pt.isec.a2018019825.f7.logica;

import pt.isec.a2018019825.f7.logica.dados.Jogo;
import pt.isec.a2018019825.f7.logica.estados.IEstado;
import pt.isec.a2018019825.f7.logica.estados.Inicio;

public class MaquinaEstados {

    IEstado atual;
    Jogo jogo;

    public MaquinaEstados() {
        jogo = new Jogo();
        atual = new Inicio(jogo);
    }

    public void comeca(){
        atual.comeca();
    }
    public void aposta(int nBolas){
        atual.aposta(nBolas);
    }
    public void tira2BolasdoSaco(){
        atual.tira2BolasDoSaco();
    }

    public void removeBolaBrancadaPilha(){
        atual.removeBolaBrancadaPilha();
    }

    public void termina(){
        atual.termina();
    }

    public Situacao getSituacao(){
        return atual.getSituacao();
    }

    //da instancia da classe de dados (Jogo) so disponibilizamos gets!
    public int getNrBolasBrancas(){
        return jogo.getNrBolasBrancasGanhas();
    }

    public String getSituacaoJogo(){
        return jogo.toString();
    }

/* Nunca fazer o método similar ao seguinte - nao dar acesso direto ao estado
    Jogo getJogo(){
        return jogo;
    }
 */

}
