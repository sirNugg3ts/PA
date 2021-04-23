package pt.isec.a2018019825.F6.sequencias.logica;


import pt.isec.a2018019825.F6.sequencias.logica.dados.JogoDados;
import pt.isec.a2018019825.F6.sequencias.logica.estados.IEstado;

public class JogoMaqEstados {

    private JogoDados jogoDados;
    private IEstado estado;

    public JogoMaqEstados() {
        jogoDados = new JogoDados();
        //estado = ...
    }

    //  metodos que consultam

    public String toString()    {
        return estado.getSituacaoAtual() + "\n" +jogoDados.toString();
    }

    public Situacao getSituacaoAtual() {
        return estado.getSituacaoAtual();
    }

    // regista novo esstado activo
    private void setEstado(IEstado estado) {
        this.estado = estado;
    }

    // acoes delegadas no estado


}
