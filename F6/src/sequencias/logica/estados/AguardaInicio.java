package sequencias.logica.estados;

import sequencias.logica.Situacao;
import sequencias.logica.dados.JogoDados;

public class AguardaInicio extends EstadoAdapter{

    protected AguardaInicio(JogoDados j) {
        super(j);
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_INICIO;
    }
}
