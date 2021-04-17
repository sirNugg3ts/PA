package pt.isec.a20180198215.F3E2;

import pt.isec.a20180198215.F3E2.iu.BiblioIU;
import pt.isec.a20180198215.F3E2.modelo.Biblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("DEIS-ISEC");
        BiblioIU biblioIU = new BiblioIU(biblioteca);
        biblioIU.comeca();
    }
}
