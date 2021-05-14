package sequencias.logica.estados;

import sequencias.logica.Situacao;
import sequencias.logica.dados.JogoDados;

public class AguardaRelancamento extends EstadoAdapter{

    public AguardaRelancamento(JogoDados j) {
        super(j);
    }

    @Override
    public IEstado recolher(int indice) {
        jogoDados.recolheDado(indice);
        return new AguardaRelancamento(jogoDados);
    }

    @Override
    public IEstado relancar() {
        if(!jogoDados.lancaDados())
            return this;
        if (jogoDados.getnRelancamentos()>0)
            return new AguardaRelancamento(jogoDados);
        return new AguardaSequencia(jogoDados);

    }

    @Override
    public IEstado avaliar() {
        jogoDados.lancaDados();
        return new AguardaSequencia(jogoDados);
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_RELANCAMENTO;
    }
}
