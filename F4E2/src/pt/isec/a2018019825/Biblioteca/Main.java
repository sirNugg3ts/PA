package pt.isec.a2018019825.Biblioteca;

import pt.isec.a2018019825.Biblioteca.modelo.Biblioteca;
import pt.isec.a2018019825.Biblioteca.iu.BiblioIU;
import pt.isec.a2018019825.Biblioteca.modelo.BibliotecaSet;

public class Main {

    static boolean testes(){

        

        return true;
    }

    public static void main(String[] args) {
        if(testes())
            return;
        Biblioteca biblioteca = new BibliotecaSet("DEIS-ISEC-Set");
        BiblioIU biblioIU = new BiblioIU(biblioteca);
        biblioIU.comeca();

    }
}
