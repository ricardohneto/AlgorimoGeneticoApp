package Util;

import Dominio.Solucao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SolucaoUtil {

    public static Solucao solucaoTeitzAndBart() {
        int vertices[][] = SolucaoUtil.carregarVertices();
        int totalPontos = 10;
        int solucao[] = new int[totalPontos];

        for (int i = 0; i < totalPontos; i++) {
            solucao[i] = (int)(Math.random() * vertices.length);
        }

        double fitness = SolucaoUtil.gerarAvaliacao(solucao, vertices);
        int backupSolucao;
        double novoFitness;

        for (int i = 0; i < totalPontos; i++) {
            backupSolucao = solucao[i];
            for (int j = 0; j < vertices.length; j++) {
                solucao[i] = j;
                novoFitness = SolucaoUtil.gerarAvaliacao(solucao, vertices);

                if (novoFitness < fitness) {
                    fitness = novoFitness;
                    backupSolucao = j;
                }
            }
            solucao[i] = backupSolucao;
        }

        Solucao melhorSolucao = new Solucao(solucao, fitness);
        return melhorSolucao;
    }

    protected static int[][] carregarVertices() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String linha, ponto = "";
        int pos = 0, cont;

        try {
            fileReader = new FileReader("324.txt");
            bufferedReader = new BufferedReader(fileReader);
            int pontos[][] = new int[Integer.parseInt(bufferedReader.readLine())][2];

            while (bufferedReader.ready()) {
                linha = bufferedReader.readLine();
                cont = 0;
                for (int i = 0; i < linha.length(); i++) {
                    if (linha.charAt(i) != ' ') {
                        ponto += linha.charAt(i);
                    }

                    if (linha.charAt(i) == ' ' || i == linha.length() - 1) {
                        pontos[pos][cont] = Integer.parseInt(ponto);
                        ponto = "";
                        cont++;
                    }
                }
                pos++;
            }
            bufferedReader.close();
            fileReader.close();
            return pontos;
        } catch (IOException e) {
            System.out.println("Erro no arquivo!");
            return null;
        }
    }

    protected static double gerarAvaliacao(int facilidades[], int pontos[][]) {
        int maxPontos = pontos.length;
        double somatorio = 0;
        double distancia;
        double menorDistancia;

        for (int i = 0; i < maxPontos; i++) {
            menorDistancia = Double.MAX_VALUE;
            for (int j = 0; j < facilidades.length; j++) {
                distancia = calcularDistancia(pontos, i, facilidades[j]);
                if (menorDistancia > distancia) {
                    menorDistancia = distancia;
                }
            }
            somatorio += menorDistancia;
        }
        return somatorio;
    }

    private static double calcularDistancia(int pontos[][], int i, int facilidade) {
        int x = pontos[i][0] - pontos[facilidade][0];
        int y = pontos[i][1] - pontos[facilidade][1];
        return Math.sqrt(Math.pow(y, 2) + Math.pow(x, 2));
    }
}
