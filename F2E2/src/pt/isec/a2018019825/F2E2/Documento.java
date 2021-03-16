package pt.isec.a2018019825.F2E2;

import java.util.Arrays;

public class Documento {
    private static final int INC_AUTORES = 5;
    private int nrAutores;
    private String titulo;
    private String [] autores;
    private StringBuffer texto;

    public Documento(String titulo) {
        this.titulo = titulo;
        autores = new String[INC_AUTORES];
        texto = new StringBuffer();
        nrAutores=0;
    }

    public String getTitulo(){
        return titulo;
    }

    public String[] getAutores() {
        return Arrays.copyOf(autores,nrAutores);
    }

    public String getTexto() {
        if (texto == null)
            return "";
        return texto.toString();
    }

    public boolean ascrescentaAutor(String autor){
        if(nrAutores >= autores.length){
            /*String [] novoAutores = new String[autores.length+INC_AUTORES];
            System.arraycopy(autores,0,novoAutores,0,autores.length);
            autores = novoAutores;*/
            autores = Arrays.copyOf(autores,autores.length+INC_AUTORES);
            return true;
        }
        return false;

    }
    
    public boolean removeAutor(String autor){
        for (int i = 0; i < nrAutores; i++) {
            if(autor.equalsIgnoreCase(autores[i])){
                for(int j =i;j < nrAutores-1;j++){
                    autores[j] = autores[j+1];
                }
                nrAutores--;
                autores[nrAutores] = null;

                if(autores.length >= nrAutores + 2 * INC_AUTORES)
                    autores = Arrays.copyOf(autores,nrAutores+INC_AUTORES);
            }
        }
        return false;

    }
}
