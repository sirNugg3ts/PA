package sequencias;


import sequencias.iu.texto.IUtexto;
import sequencias.logica.JogoMaqEstados;

public class Principal {
    public static void main(String[] args) {
        JogoMaqEstados jogoMaqEstados = new JogoMaqEstados();
        IUtexto iuTexto = new IUtexto(jogoMaqEstados);
        iuTexto.corre();
    }
}
