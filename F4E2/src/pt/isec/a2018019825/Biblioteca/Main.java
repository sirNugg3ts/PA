package pt.isec.a2018019825.Biblioteca;



import pt.isec.a2018019825.Biblioteca.modelo.BibliotecaSet;
import pt.isec.a2018019825.Biblioteca.iu.BiblioIU;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.Scanner;

public class Main {

    class LivroException extends Exception{

    }

    static boolean testes(){
        int i=0;
        File f = new File("fich.dat");



        try {
            //throw new LivroException();
            //bytes
            OutputStream os;
            InputStream is;
            FileInputStream fis = new FileInputStream(f);
            FileOutputStream fos = new FileOutputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            DataOutputStream dos = new DataOutputStream(fos);

            ObjectInputStream ois = new ObjectInputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(fos);


            //text
            Writer wr;
            Reader re;
            FileWriter fw = new FileWriter(f);
            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);

            PrintWriter pw = new PrintWriter(bw);
            Scanner sc = new Scanner(br);

            sc.close();
            bw.close();
            br.close();

            i = 10;
        } catch (FileNotFoundException e) {

            System.err.println("O ficheiro não existe");
            i=5;;
        } catch(IOException e){
            System.err.println("Outro erro");
        }catch(Exception e){
            System.err.println("Mais um erro");
        }finally {
            System.out.println("Isto vai ser sempre executado");
        }

        i+= 5;


        return true;
    }

    public static void main(String[] args) {
       // if(testes())
         //   return;
        BibliotecaSet biblioteca = new BibliotecaSet("DEIS-ISEC-Set");
        BiblioIU biblioIU = new BiblioIU(biblioteca);
        biblioIU.comeca();

    }
}
