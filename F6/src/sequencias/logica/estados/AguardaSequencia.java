package sequencias.logica.estados;

import sequencias.logica.Situacao;
import sequencias.logica.dados.JogoDados;

public class AguardaSequencia extends EstadoAdapter{
    public AguardaSequencia(JogoDados j) {
        super(j);
    }

    @Override
    public IEstado recolher(int indice) {
        jogoDados.recolheDado(indice);
        return new AguardaSequencia(jogoDados);
    }

    @Override
    public IEstado avaliar() {
        if (jogoDados.getnDadosMao() == 0)
            return this;
        jogoDados.avaliaSequencia();
        if (jogoDados.jogoTerminou())
            return new AguardaInicio(jogoDados);
        return new AguardaSequencia(jogoDados);
    }

    @Override
    public IEstado terminar() {
        if (jogoDados.getnDadosMao()>0)
            return this;
        return new AguardaInicio(jogoDados);
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AVALIAR_SEQUENCIA;
    }
}
