package sequencias.logica;

import sequencias.logica.dados.JogoDados;
import sequencias.logica.estados.AguardaInicio;
import sequencias.logica.estados.IEstado;

public class JogoMaqEstados {

    private JogoDados jogoDados;
    private IEstado estado;

    public JogoMaqEstados() {
        jogoDados = new JogoDados();
        estado = new AguardaInicio(jogoDados);
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
    void comecar(){
        setEstado(estado.comecar());
    }
    void recolher(int indice){
        setEstado(estado.recolher(indice));
    }
    void relancar(){
        setEstado(estado.relancar());
    }
    void avaliar(){
        setEstado(estado.avaliar());
    }
    void terminar(){
        setEstado(estado.terminar());
    }

}
