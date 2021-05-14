package sequencias.logica.estados;

import sequencias.logica.Situacao;
import sequencias.logica.dados.JogoDados;

public class AguardaInicio extends EstadoAdapter{

    public AguardaInicio(JogoDados j) {
        super(j);
    }

    @Override
    public IEstado comecar() {
        jogoDados.inicia();
        jogoDados.lancaDados();
        return new AguardaRelancamento(jogoDados);
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_INICIO;
    }
}
