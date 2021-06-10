package Dominio;

public class Populacao {

    private Solucao[] solucoes;

    public Populacao(Solucao[] solucoes) {
        this.solucoes = solucoes;
    }

    public Solucao[] getSolucoes() {
        return solucoes;
    }

    public void setSolucoes(Solucao[] solucoes) {
        this.solucoes = solucoes;
    }

    public String exibirPopulacao() {
        String resp = "";

        for (int i = 0; i < solucoes.length; i++) {
            resp += solucoes[i].exibirSolucao() + "\n";
        }

        return resp;
    }

    public Solucao exibirMelhorFitness() {
        Solucao melhor = solucoes[0];

        for (int i = 1; i < solucoes.length; i++) {
            if (solucoes[i].getFitness() < melhor.getFitness()) {
                melhor = solucoes[i];
            }
        }

        return melhor;
    }

}
