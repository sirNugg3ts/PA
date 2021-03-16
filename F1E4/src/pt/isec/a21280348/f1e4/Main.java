package pt.isec.a21280348.f1e4;

class Tabela {
    static final int TAM_TAB = 20;

    private int[] tab;
    private int nrtentativas = 0;
    private int nrvalores; // numero de valores corretamente sorteado

    public Tabela() {
        tab = new int[TAM_TAB];
        nrvalores = 0;
    }

    boolean existe(int valor) {
        for (int i = 0; i < nrvalores; i++) {
            if (tab[i] == valor)
                return true;
        }
        return false;
    }

    void preenche() {
        while (nrvalores < TAM_TAB) {
            nrtentativas++;
            int valor = (int) (Math.random() * 101);
            if (!existe(valor))
                tab[nrvalores++] = valor;
        }
    }

    public int nrDuplicados() {
        return nrtentativas - nrvalores;
    }

    public void mostra() {
        System.out.println("[");
        for (int i = 0; i < nrvalores; i++) {
            if (i != 0)
                System.out.print(" ,");
            System.out.println(tab[i]);
        }
        System.out.println("]");
    }
}


public class Main {
    public static void main(String[] args) {
        Tabela tabela = new Tabela();
        tabela.preenche();
        System.out.println("n duplicados:" + tabela.nrDuplicados());
        tabela.mostra();
    }
}
