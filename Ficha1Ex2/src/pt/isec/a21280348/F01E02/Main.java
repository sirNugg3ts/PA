package pt.isec.a21280348.F01E02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello World");
        Scanner scanner = new Scanner(System.in);

        int menor =1, maior = 100, hipotese,resp;

        do{
            hipotese = (maior+menor) / 2;

            System.out.println("O número é o "+hipotese+" ?"+
                    "[ 0 - Sim; 1 - Não, é menor; 2 - Não, é maior]");
            try {
                resp = scanner.nextInt();}
            catch (Exception e){
                System.err.println(e);
                resp = -1;
            }
           ;

            switch (resp){
                case 1:
                    maior = hipotese - 1;
                    break;
                case 2:
                    menor = hipotese + 1;
                    break;
            }
        } while (resp != 0 && maior >= menor);

        if (resp==0)
            System.out.println("Ok o numero era: "+hipotese);
        else
            System.out.println("Dude you're lying to me");
    }
}
