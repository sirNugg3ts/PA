package pt.isec.a2018019825.jogoenforcado;

import java.util.Scanner;

public class JogoEnforcadoUI {
    JogoEnforcadoModelo jogo;
    public JogoEnforcadoUI(JogoEnforcadoModelo jogo) {
        this.jogo = jogo;
    }

    public void jogar(){
        Scanner sc = new Scanner(System.in);
        String opcao;

        while(!jogo.concluido()){

            System.out.println(jogo.getSituacao());
            System.out.println();
            System.out.println("Tentativas realizadas: " + jogo.getTentativas());
            System.out.println("Caracteres jogados: " + jogo.getUsadas());
            System.out.println();

            System.out.print("Caracter ou palavra completa com " +
                    jogo.getSituacao().length() + " caracteres para finalizar: ");
            opcao = sc.next().toUpperCase();
            opcao = opcao.trim();
            jogo.setOpcao(opcao);
            System.out.println();

        }
        if (jogo.acertou())
            System.out.println("Parabens, acertou na palavra \"" + jogo.getPalavra() + "\" em " + jogo.getTentativas() + " tentativas!");
        else
            System.out.println("Apos "+jogo.getTentativas()+
                    " tentativas nao acertou na palavra que era \"" + jogo.getPalavra());

    }
}
