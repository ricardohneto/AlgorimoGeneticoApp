package Util;

import Dominio.Populacao;
import Dominio.Solucao;

public class ReinsercaoUtil {

    public static void realizarReinsercao(Populacao populacao, Solucao filho, Solucao[] pais) {
        if ((filho.getFitness() < pais[0].getFitness()) && (filho.getFitness() < pais[1].getFitness())) {
            Solucao piorPai = retornaPiorPai(pais);

            for (int i = 0; i < populacao.getSolucoes().length; i++) {
                if (populacao.getSolucoes()[i].getFitness() == piorPai.getFitness()) {
                    populacao.getSolucoes()[i] = filho;
                }
            }
        }
    }

    private static Solucao retornaPiorPai(Solucao[] pais) {
        if (pais[0].getFitness() < pais[1].getFitness()) {
            return pais[1];
        } else {
            return pais[0];
        }
    }

}
