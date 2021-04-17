package pt.a2018019825.isec.elevador;

import pt.a2018019825.isec.elevador.logica.MaquinaEstados;
import pt.a2018019825.isec.elevador.ui.ElevadorUI;


public class Main {
    public static void main(String[] args) {
        MaquinaEstados maquinaEstados = new MaquinaEstados();
        ElevadorUI elevadorUI = new ElevadorUI(maquinaEstados);
        elevadorUI.run();
    }
}
