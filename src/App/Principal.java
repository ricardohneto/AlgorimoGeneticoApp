package App;

import Dominio.Populacao;
import Dominio.Solucao;
import Util.CloneUtil;
import Util.CruzamentoUtil;
import Util.MutacaoUtil;
import Util.ReinsercaoUtil;
import Util.SolucaoUtil;
import Util.SelecaoUtil;
import Util.Util;

public class Principal {
    public static void main(String[] args) {
        // parametros iniciais da população e soluções
        final int totalPopulacao = 100;
        final int chanceMutacao = 2;
        final int genesMutados = 1;
        final int metaFitness = 79000;

        // gera quantidade de solucoes para o total da população
        Solucao[] solucoes = new Solucao[totalPopulacao];
        for (int i = 0; i < solucoes.length; i++) {
            Solucao solucao = SolucaoUtil.solucaoTeitzAndBart();
            solucoes[i] = solucao;
        }

        // instancia uma população
        Populacao populacao = new Populacao(solucoes);

        do {
            // seleção feita pelo metodo de torneio e reverte a população para as duas melhores soluções
            Solucao[] pais = SelecaoUtil.realizarTorneio(populacao);

            // exibe a solucao selecionada após torneio
            // for (int i = 0; i < solucaoSelecionados.length; i++) {
            //     System.out.println(solucaoSelecionados[i].exibirSolucao());
            // }

            // cruzamento feita pelo metodo de mascara de torneio e retorna o melhor entre os 2 filhos gerados
            Solucao filho = CruzamentoUtil.realizarMascaraCruzamento(pais);

            // exibe filho gerado após o cruzamento
            // System.out.println(filho.exibirSolucao());

            // realiza processo de possível mutação do gene filho
            MutacaoUtil.realizarMutacao(filho, chanceMutacao, genesMutados);

            // exibe filho gerado após processo de mutação
            // System.out.println(filho.exibirSolucao());

            boolean isClone = CloneUtil.realizarDeteccaoClones(filho, populacao);

            // se o filho escolhido não for um clone realiza a reinserção
            if (!isClone) {
                ReinsercaoUtil.realizarReinsercao(populacao, filho, pais);
            }

            System.out.println(populacao.exibirMelhorFitness().exibirSolucao());

        } while(populacao.exibirMelhorFitness().getFitness() > metaFitness);

        Util.printarSolucao(populacao);
    }
}
