package pt.a2018019825.isec.elevador.ui;

import pt.a2018019825.isec.elevador.logica.MaquinaEstados;
import pt.a2018019825.isec.elevador.utils.util;

public class ElevadorUI {
    MaquinaEstados estados;
    boolean sair;
    public ElevadorUI(MaquinaEstados maquinaEstados) {
        this.estados = maquinaEstados;
    }

    public void run(){
        sair = false;
        while (!sair){
            System.out.println(estados.getHistorico());
            switch(estados.getSituacaoAtual()){
                case RC:
                    uiRC();
                    break;
                case Piso1:
                    uiPiso1();
                    break;
                case Piso2:
                    uiPiso2();
                    break;
                case Avariado:
                    uiAvariado();
                    break;
            }
        }

    }

    private void uiAvariado() {
        System.out.println("Avariado:");
        switch(util.escolheOpcao("Insere chave","Sair")){
            case 1:
                estados.insereChave();
                break;
            default:
                sair = true;
                break;
        }
    }

    private void uiPiso2() {
        System.out.println("Piso 2:");
        switch(util.escolheOpcao("Desce","Sair")){
            case 1:
                estados.desce();
                break;
            default:
                sair = true;
                break;
        }
    }

    private void uiPiso1() {
        System.out.println("Piso 1:");
        switch(util.escolheOpcao("Desce","Sobe","Sair")){
            case 1:
                estados.desce();
                break;
            case 2:
                estados.sobe();
                break;
            default:
                sair = true;
                break;
        }
    }

    private void uiRC() {
        System.out.println("RC:");
        switch(util.escolheOpcao("Sobe","Sair")){
            case 1:
                estados.sobe();
                break;
            default:
                sair = true;
                break;
        }
    }
}