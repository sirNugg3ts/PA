package pt.isec.a2018019825.f7.UI;

import pt.isec.a2018019825.f7.Utils.UtilUI;
import pt.isec.a2018019825.f7.logica.MaquinaEstados;

public class BolasUI {
    MaquinaEstados me;
    boolean sair;
    public BolasUI(MaquinaEstados me) {
        this.me = me;
    }

    public void mostraLog(){
        for(String msg : me.getLog())
            System.out.println(msg);
        me.clearLog();
    }
    public void comeca() {
        sair = false;
        while (!sair){
            mostraLog();
            System.out.println(me.getSituacaoJogo());
            switch(me.getSituacao()){
                case Inicio:
                    inicioUI();
                    break;
                case EsperarAposta:
                    esperarApostaUI();
                    break;
                case EsperarDecisaoPerda:
                    esperarDecisaoPerdaUI();
                    break;
                case FimJogo:
                    fimJogoUI();
                    break;
            }
        }
    }

    private void inicioUI() {
        int op = UtilUI.escolheOpcao("Comecar","Sair");
        switch (op){
            case 1:
                me.comeca();
                break;
            default:
                sair = true;
                break;
        }
    }

    private void esperarApostaUI(){
        switch(UtilUI.escolheOpcao("Apostar","Terminar","Sair")){
            case 1:
                int aposta;
                do{
                    aposta = UtilUI.pedeInteiro("Qual a aposta [0.."+me.getNrBolasBrancasGanhas()+"]: ");
                }while(aposta<0 || aposta > me.getNrBolasBrancasGanhas());
                me.aposta(aposta);
                break;
            case 2:
                me.termina();
                break;
            default:
                sair = true;
                break;
        }
    }

    private void esperarDecisaoPerdaUI(){
        System.out.println("Saiu bola preta. Perdeu a aposta");
        switch (UtilUI.escolheOpcao("Perder Branca","Tirar 2 bolas do saco","sair")){
            default:
                sair = true;
                break;
            case 1:
                me.removeBolaBrancadaPilha();
                break;
            case 2:
                me.tira2BolasdoSaco();
                break;
        }
    }

    private void fimJogoUI(){
        System.out.println("O jogo terminou!!!!");
        System.out.printf("Ganhou %d bolas brancas \n",me.getNrBolasBrancasGanhas());
        switch (UtilUI.escolheOpcao("Comecar","Sair")){
            case 1:
                me.comeca();
                break;
            default:
                sair = true;
                break;
        }
    }
}
