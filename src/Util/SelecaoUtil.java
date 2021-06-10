package Util;

import Dominio.Populacao;
import Dominio.Solucao;

import java.util.ArrayList;
import java.util.Arrays;


public class SelecaoUtil {

    public static Solucao[] realizarTorneio(Populacao populacao) {
        int primeiraSolucao;
        int segundaSolucao;
        Solucao [] solucoes = populacao.getSolucoes();

        while(solucoes.length > 2) {
            do {
                primeiraSolucao = Util.gerarValorAleatorio(solucoes.length);
                segundaSolucao = Util.gerarValorAleatorio(solucoes.length);
            } while(primeiraSolucao == segundaSolucao);

            if (solucoes[primeiraSolucao].getFitness() < solucoes[segundaSolucao].getFitness()) {
                Solucao perdedor = solucoes[segundaSolucao];
                solucoes = removerSolucao(solucoes, perdedor);
            } else {
                Solucao perdedor = solucoes[primeiraSolucao];
                solucoes = removerSolucao(solucoes, perdedor);
            }
        }

        return solucoes;
    }

    public static Solucao[] removerSolucao(Solucao[] solucoes, Solucao perdedor) {
        ArrayList<Solucao> a = new ArrayList<>(Arrays.asList(solucoes));
        a.remove(perdedor);
        solucoes = new Solucao[a.size()];
        return a.toArray(solucoes);
    }

}
