package sequencias.iu.texto;

import sequencias.logica.JogoMaqEstados;
import sequencias.logica.Situacao;

import java.util.Scanner;


public class IUtexto {

    private JogoMaqEstados jogoMaqEstados;
    private boolean sair = false;
    private Scanner sc = new Scanner(System.in);

    public IUtexto(JogoMaqEstados jogoMaqEstados) {
        this.jogoMaqEstados = jogoMaqEstados;
    }


    public void corre() {

        while (!sair) {
            Situacao situacao = jogoMaqEstados.getSituacaoAtual();
            System.out.println("" + jogoMaqEstados);
            switch (situacao) {
                case ESTADO1:
                    break;
                case ESTADO2:
                    break;
                case ESTADOZ:
                    break;
            }
        }
    }

}
