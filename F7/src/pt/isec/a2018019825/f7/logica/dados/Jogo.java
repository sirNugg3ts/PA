package pt.isec.a2018019825.f7.logica.dados;

import pt.isec.a2018019825.f7.logica.TipoBola;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jogo {
    public static final int NRBRANCAS = 10;
    public static final int NRPRETAS  = 10;
    ArrayList<TipoBola> saco;
    int nrBolasBrancasGanhas,nrBolasPretasFora,nrBolasBrancasFora;
    int aposta;

    // ---- Logs -----

    ArrayList<String> log = new ArrayList<>();

    public void addLog(String str){
        log.add(str);
    }

    public List<String> getLog(){
        return log;
    }

    public void clearLog(){
        log.clear();
    }

    //---------------------------
    public Jogo() {
        iniciaJogo();
    }

    public void iniciaJogo() {
        saco = new ArrayList<>();
        saco.addAll(Collections.nCopies(NRBRANCAS,TipoBola.Branca));
        saco.addAll(Collections.nCopies(NRPRETAS,TipoBola.Preta));
        nrBolasBrancasGanhas = 0;
        nrBolasBrancasFora = 0;
        nrBolasPretasFora = 0;
        aposta = 0;
        Collections.shuffle(saco);
    }

    public int getNrBolasBrancasGanhas() {
        return nrBolasBrancasGanhas;
    }

    public int getNrBolasPretasFora() {
        return nrBolasPretasFora;
    }

    public int getNrBolasBrancasFora() {
        return nrBolasBrancasFora;
    }

    public boolean isSacoVazio() {
        return saco.isEmpty();
    }

    public boolean aposta(int bolas) {
        if (bolas > nrBolasBrancasGanhas) {
            return false;
        }
        nrBolasBrancasGanhas -= bolas;
        aposta = bolas;
        return true;
    }

    public int getAposta() {
        return aposta;
    }

    public void perdeAposta() {
        // nrBolasBrancasGanhas -= aposta; //se não fossem antes retiradas
    }

    public void recuperaAposta() {
        nrBolasBrancasGanhas += aposta;
    }

    public void ganhaBranca() {
        nrBolasBrancasGanhas += 1;
    }

    public boolean perdeBranca() {
        if (nrBolasBrancasGanhas < 1)
            return false;
        nrBolasBrancasGanhas--;
        return true;
    }

    public void retiraPreta() {
        nrBolasPretasFora++;
    }

    public void retiraBranca() {
        nrBolasBrancasFora++;
    }


    public void devolveBolas(int nrBolas, TipoBola tipo) {
        if (nrBolas>0)
            saco.addAll(Collections.nCopies(nrBolas,tipo));
        Collections.shuffle(saco);
    }

    public TipoBola tiraBolaDoSaco() {
        if (saco.isEmpty()) {
            return TipoBola.none;
        }
        return saco.remove(0);
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "saco=" + saco +
                ", nrBolasBrancasGanhas=" + nrBolasBrancasGanhas +
                ", nrBolasPretasFora=" + nrBolasPretasFora +
                ", nrBolasBrancasFora=" + nrBolasBrancasFora +
                ", aposta=" + aposta +
                '}';
    }
}
