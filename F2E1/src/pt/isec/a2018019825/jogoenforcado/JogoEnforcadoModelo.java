package pt.isec.a2018019825.jogoenforcado;

public class JogoEnforcadoModelo {
    private static final int MAX_TENTATIVAS = 7;

    private String palavra;
    private StringBuffer situacao; // estado da descoberta da palavra. Inicial "......"
    private StringBuilder usadas; //letras usadas ate ao momento
    private int tentativas,nracertos;

    public JogoEnforcadoModelo(){
        inicia();
    }

    public void inicia(){
        tentativas = 0;
        nracertos = 0;
        int sorteio = (int)(Math.random() * JogoEnforcadoDicionario.getTamanho());
        palavra = JogoEnforcadoDicionario.getPalavra(sorteio);
        situacao = new StringBuffer(
                ".".repeat(palavra.length()));
        usadas = new StringBuilder();
    }

    public boolean concluido() {
        return acertou() || tentativas - nracertos >= MAX_TENTATIVAS;
    }

    public String getSituacao() {
        return situacao.toString();
    }

    public int getTentativas() {
        return tentativas;
    }

    public String getUsadas() {
        return usadas.toString();
    }

    public void setOpcao(String opcao) {
        if(concluido())
            return;
        tentativas++;
        if(opcao.isBlank())
            return;
        opcao = opcao.toUpperCase();
        if(opcao.length() > 1){
            if(palavra.equals(opcao))
                situacao = new StringBuffer(palavra);
            return;
        }
        char chOpcao = opcao.charAt(0);
        usadas.append(chOpcao);
        String inicial = situacao.toString();

        for(int i =0;i<palavra.length();i++){
            if(palavra.charAt(i) == chOpcao){
                situacao.setCharAt(i,chOpcao);
            }
        }
        if(inicial.equalsIgnoreCase(situacao.toString()))
            nracertos++;
    }

    public String getPalavra() {
        return palavra;
    }

    public boolean acertou() {
        return palavra.equalsIgnoreCase(situacao.toString());

    }
}
