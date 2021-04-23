package pt.isec.a2018019825.F6.sequencias;


import pt.isec.a2018019825.F6.sequencias.iu.texto.IUtexto;
import pt.isec.a2018019825.F6.sequencias.logica.JogoMaqEstados;

public class Principal {
    public static void main(String[] args) {
        JogoMaqEstados jogoMaqEstados = new JogoMaqEstados();
        IUtexto iuTexto = new IUtexto(jogoMaqEstados);
        iuTexto.corre();
    }
}
