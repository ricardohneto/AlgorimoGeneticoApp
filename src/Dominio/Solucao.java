package Dominio;

public class Solucao {

    private int[] vertices;
    private double fitness;

    public Solucao(int[] vertices, double fitness) {
        this.vertices = vertices;
        this.fitness = fitness;
    }

    public int[] getVertices() {
        return vertices;
    }

    public double getFitness() {
        return fitness;
    }

    public String exibirSolucao() {
        String resp = "|";

        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] > 99) {
                resp += " " + vertices[i] + " |";
            } else if (vertices[i] > 9) {
                resp += " 0" + vertices[i] + " |";
            } else {
                resp += " 00" + vertices[i] + " |";
            }

        }

        return resp + " = " + fitness;
    }
}
