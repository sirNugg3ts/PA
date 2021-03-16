package pt.isec.a2018019825.f1e6;

import java.util.Arrays;

public class Matriz {
    float [][] matriz;
    int linhas,colunas;

    public Matriz(int linhas, int colunas){
        this.linhas = linhas;
        this.colunas = colunas;
        matriz = new float[linhas][colunas];
        for(int i = 0;i < linhas;i++){
            Arrays.fill(matriz[i], 1.0f*i);

        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Matriz newm = new Matriz(linhas,colunas);
        for(int i = 0;i < linhas;i++){
            newm.matriz[i]  = Arrays.copyOf(matriz[i],matriz[i].length);
        }
        return newm;
    }
/*
    public Matriz(Matriz m){
        this.linhas = m.linhas;
        this.colunas = m.colunas;
        for(int i = 0;i < linhas;i++){
            this.matriz[i]  = Arrays.copyOf(m.matriz[i],m.matriz[i].length);
        }
    }
*/
    public int getLinhas(){
        return linhas;
    }

    public int getColunas(){
        return colunas;
    }

    public boolean setValor(int linha,int coluna, float valor){
        if(linha < 0 || coluna < 0 || linha >=  this.linhas || coluna >= this.colunas)
            return false;
        else{
            this.matriz[linha][coluna] = valor;
            return true;
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<linhas;i++){
            for(int j =0;j<colunas;j++){
                str.append(String.format(" %5.2f",matriz[i][j]));
            }
            str.append("\n");
        }
        return str.toString();
    }

    public boolean acumula(Matriz m){
        if (linhas != m.linhas || colunas != m.colunas)
            return false;

        for(int i = 0;i<linhas;i++) {
            for (int j = 0; j < colunas; j++) {
                this.matriz[i][j] += m.matriz[i][j];
            }
        }
        return true;
    }

    public Matriz adiciona(Matriz m){
        if (linhas != m.linhas || colunas != m.colunas)
            return null;
        Matriz res = null;
        try{
            res = (Matriz) this.clone();
            res.acumula(m);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static Matriz adiciona(Matriz m1,Matriz m2){
        return m1.adiciona(m2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matriz matriz1 = (Matriz) o;

        if (linhas != matriz1.linhas) return false;
        if (colunas != matriz1.colunas) return false;
        return Arrays.deepEquals(matriz, matriz1.matriz);
    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(matriz);
        result = 31 * result + linhas;
        result = 31 * result + colunas;
        return result;
    }
}
