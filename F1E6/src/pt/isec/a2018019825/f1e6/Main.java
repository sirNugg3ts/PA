package pt.isec.a2018019825.f1e6;



public class Main {
    public static void main(String[] args) {
        Matriz m1 = new Matriz(3,4);
        Matriz m2 = null;
        try {
            m2= (Matriz) m1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("Passo 1:");
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m1.equals(m2));
        m1.setValor(1,1,3.1415f);
        m2.setValor(2,2,3.1415f);


        System.out.println("Passo 2:");
        System.out.println(m1);
        System.out.println(m2);

        //m1.acumula(m2);

        Matriz m3 = Matriz.adiciona(m1,m2);
        System.out.println("Passo 3:");
        System.out.println(m3);
    }
}
