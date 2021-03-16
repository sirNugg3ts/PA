package pt.isec.a2018019825.F1E8;

public class TrianguloPascal {
    int profundidade = 0;
    int [][] triangulo;

    public TrianguloPascal(int profundidade){
        this.profundidade = profundidade;

        if(profundidade < 1)
            throw new IllegalArgumentException();

        triangulo = new int[profundidade][];
        for(int i= 0;i < profundidade;i++){
            triangulo[i] = new int[i+1];
            triangulo[i][0] = 1;
            for(int j = 0;j < i;j++){
                triangulo[i][j] = triangulo[i-1][j-1] + triangulo[i-1][j-1];
            }
            triangulo[i][i] = 1;
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < triangulo.length; i++) {
            //sb.append(" ".repeat((int)((profundidade-i)/2.0*6)));
            for (int j = 0; j < triangulo[i].length; j++) {
                sb.append(String.format("%6d", triangulo[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
