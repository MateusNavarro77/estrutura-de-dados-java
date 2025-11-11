package com.mateusnavarro77.algoritmos.dijkstra;

public class WeightedEdge {
    private int v;
    private int w;
    private double weight;

    public WeightedEdge(int v, int w, double weight) {

        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    @Override
    public String toString() {
        return "WeightedEdge [v=" + v + ", w=" + w + ", weight=" + weight + "]";
    }

}
