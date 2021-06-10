package Util;

import Dominio.Solucao;

public class MutacaoUtil {

    public static Solucao realizarMutacao(Solucao filho, int chanceMutacao, int genesMutados) {
        int deveSofrerMutacao = Util.gerarValorAleatorio(100);

        if (chanceMutacao <= deveSofrerMutacao) {
            for (int i = 0; i < genesMutados; i++) {
                int pos = Util.gerarValorAleatorio(filho.getVertices().length);
                filho.getVertices()[pos] = Util.gerarValorAleatorio(324);
            }
        }

        return filho;
    }

}
