package pt.isec.a2018019825.f7;

import pt.isec.a2018019825.f7.UI.BolasUI;
import pt.isec.a2018019825.f7.logica.MaquinaEstados;

public class main {
    public static void main(String[] args) {
        MaquinaEstados me = new MaquinaEstados();
        BolasUI bolasUI = new BolasUI(me);
        bolasUI.comeca();
    }
}
