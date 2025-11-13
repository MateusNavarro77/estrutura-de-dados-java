package com.mateusnavarro77.algoritmos.lazyprim;

import java.util.LinkedList;

public class WeightedUndirectedGraph {
    private final int V;
    private int E;
    private LinkedList<WeightedEdge>[] adj;

    public WeightedUndirectedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<WeightedEdge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(WeightedEdge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<WeightedEdge> adj(int v) {
        return adj[v];
    }
}