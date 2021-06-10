package Util;

import Dominio.Populacao;
import Dominio.Solucao;

public class CloneUtil {

    public static boolean realizarDeteccaoClones(Solucao filho, Populacao populacao) {
        boolean isClone = false;

        for (int i = 0; i < populacao.getSolucoes().length; i++) {
            if (filho.getFitness() == populacao.getSolucoes()[i].getFitness()) {
                isClone = true;
            }
        }

        return isClone;
    }

}
