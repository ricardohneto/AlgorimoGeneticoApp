package Util;

import Dominio.Populacao;

public class Util {

    protected static int gerarValorAleatorio(int length) {
        return (int)(Math.random() * length);
    }

    public static void printarSolucao(Populacao populacao) {
        System.out.println("//////////////////////////////////");
        System.out.println("População Final:");
        System.out.println(populacao.exibirPopulacao());
        System.out.println("///////////////////////////////");
        System.out.println("Melhor Cromossomo:");
        System.out.println(populacao.exibirMelhorFitness().exibirSolucao());
    }
}
