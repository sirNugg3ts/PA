package pt.a2018019825.isec.elevador.utils;

import java.util.Scanner;

public final class util {
    static Scanner sc;

    static {
        sc=new Scanner(System.in);
    }
    private util(){

    }

    public static int pedeInteiro(String pergunta){
        System.out.println(pergunta);
        while (!sc.hasNextInt())
            sc.next();
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    public static String pedeString(String pergunta){
        String resposta;
        do{
            System.out.println(pergunta);
            resposta=sc.nextLine().trim();
        }while(resposta.isEmpty());
        return resposta;
    }

    public static int escolheOpcao(String... opcoes){
        int opcao;
        do{
            for(int i=0;i<opcoes.length-1;i++){
                System.out.printf("%3d - %s\n",i+1,opcoes[i]);
            }
            System.out.printf("\n%3d - %s\n",0,opcoes[opcoes.length-1]);
            opcao = pedeInteiro("\n> ");
        }while(opcao<0 || opcao>opcoes.length);
        return opcao;
    }

}
