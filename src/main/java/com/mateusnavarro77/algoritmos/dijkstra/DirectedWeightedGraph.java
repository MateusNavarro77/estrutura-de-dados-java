package com.mateusnavarro77.algoritmos.dijkstra;

import java.util.LinkedList;

public class DirectedWeightedGraph {

    private int v;
    private int e;
    private LinkedList<WeightedEdge>[] edgesOf;

    public DirectedWeightedGraph(int v) {
        this.v = v;
        this.e = 0;
        edgesOf = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            edgesOf[i] = new LinkedList<>();
        }
    }

    public int V() {
        return v;

    }

    public int E() {
        return e;
    }

    public Iterable<WeightedEdge> adj(int v) {

        return edgesOf[v];
    }

    public void addEdge(WeightedEdge edge) {
        edgesOf[edge.from()].add(edge);
        e++;
    }

}
