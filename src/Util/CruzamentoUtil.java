package Util;

import Dominio.Solucao;

public class CruzamentoUtil {

    public static Solucao realizarMascaraCruzamento(Solucao[] solucoes) {
        Solucao pai1 = solucoes[0];
        Solucao pai2 = solucoes[1];
        Solucao filho1;
        Solucao filho2;
        int[] vertices1 = new int [pai1.getVertices().length];
        int[] vertices2 = new int[pai1.getVertices().length];
        double fitness1;
        double fitness2;
        int[] mascara = new int[pai1.getVertices().length];
        int vertices[][] = SolucaoUtil.carregarVertices();

        for (int i = 0; i < mascara.length; i++) {
            mascara[i] = Util.gerarValorAleatorio(2);
        }

        for (int i = 0; i < pai1.getVertices().length; i++) {
            if (mascara[i] == 0) {
                vertices1[i] = pai1.getVertices()[i];
                vertices2[i] = pai2.getVertices()[i];
            } else {
                vertices1[i] = pai2.getVertices()[i];
                vertices2[i] = pai1.getVertices()[i];
            }
        }

        fitness1 = SolucaoUtil.gerarAvaliacao(vertices1, vertices);
        fitness2 = SolucaoUtil.gerarAvaliacao(vertices2, vertices);

        filho1 = new Solucao(vertices1, fitness1);
        filho2 = new Solucao(vertices2, fitness2);

        if (filho1.getFitness() < filho2.getFitness()) {
            return filho1;
        } else {
            return filho2;
        }
    }

}
