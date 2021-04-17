package pt.isec.a20180198215.F3E2.iu;

import pt.isec.a20180198215.F3E2.modelo.Biblioteca;
import pt.isec.a20180198215.F3E2.modelo.Livro;

import java.util.ArrayList;
import java.util.Scanner;

public class BiblioIU {
    Biblioteca biblio;
    Scanner sc;

    public BiblioIU(Biblioteca b) {
        this.biblio = b;
        sc = new Scanner(System.in);
    }

    public void comeca() {
        while (true) {
            switch (escolheOpcao("Adiciona livro","Pesquisa Livro",
                    "Remove Livro","Listar","Sair")) {
                case 1:
                    acrescentaLivro();
                    break;
                case 2:
                    pesquisaLivro();
                    break;
                case 3:
                    eliminaLivro();
                    break;
                case 4:
                    System.out.println(biblio.toString());
                    break;
                case 5:
                    return;
            }
        }

    }

    int pedeInteiro(String pergunta) {
        System.out.print(pergunta);
        while (!sc.hasNextInt())
            sc.next();
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    String pedeString(String pergunta) {
        String resposta;
        do {
            System.out.print(pergunta);
            resposta = sc.nextLine().trim();
        } while (resposta.isEmpty());
        return resposta;
    }

    int escolheOpcao(String... opcoes) {
        int opcao;
        do {
            for (int i = 0; i < opcoes.length; i++)
                System.out.printf("%3d - %s\n",i+1,opcoes[i]);
            opcao = pedeInteiro("\n> ");
        } while (opcao<1 || opcao>opcoes.length);
        return opcao;
    }

    void acrescentaLivro() {
        String titulo = pedeString("Indique o titulo do livro:\n> ");
        String autor;
        ArrayList<String> autores = new ArrayList<>();
        do {
            autor = pedeString("Indique um autor [\'fim\' para terminar]:\n> ");
            if (autor!=null && !autor.equalsIgnoreCase("fim"))
                autores.add(autor);
        } while (!autor.equalsIgnoreCase("fim"));
        biblio.acrescentaLivro(titulo,autores);
    }

    void pesquisaLivro() {
        int codigo = pedeInteiro("Indique o codigo do livro a pesquisar: ");
        Livro livro = biblio.pesquisaLivro(codigo);
        if (livro == null)
            System.out.println("Codigo de livro nao encontrado");
        else
            System.out.println("Livro encontrado: "+livro);
    }

    void eliminaLivro() {
        int codigo = pedeInteiro("Indique o codigo do livro a eliminar: ");
        boolean apagou = biblio.eliminaLivro(codigo);
        if (!apagou)
            System.out.println("Codigo de livro nao encontrado");
        else
            System.out.println("Livro eliminado");
    }



}
