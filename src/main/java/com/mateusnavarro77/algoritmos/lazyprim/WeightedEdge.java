package com.mateusnavarro77.algoritmos.lazyprim;

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

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v)
            return w;
        else if (vertex == w)
            return v;
        else
            throw new IllegalArgumentException("Inconsistent edge");
    }

    @Override
    public String toString() {
        return "(v: " + v + " , w: " + w + " , weight: " + weight + " )";
    }

}
