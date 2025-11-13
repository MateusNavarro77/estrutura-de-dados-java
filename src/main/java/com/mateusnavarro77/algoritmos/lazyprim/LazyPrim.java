package com.mateusnavarro77.algoritmos.lazyprim;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LazyPrim {
    private WeightedUndirectedGraph originalGraph;
    public boolean[] marked;
    public int source;
    public Queue<WeightedEdge> mst;
    public PriorityQueue<WeightedEdge> pq;

    public LazyPrim(WeightedUndirectedGraph graph, int source) {
        this.originalGraph = graph;
        this.marked = new boolean[graph.V()];
        this.source = source;
        pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.weight(), o2.weight()));
        mst = new LinkedList<>();
        visit(source);
        while (!pq.isEmpty() && mst.size() != graph.V() - 1) {
            WeightedEdge current = pq.poll();
            int v = current.either();
            int w = current.other(v);
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.add(current);
            if (!marked[v])
                visit(v);
            if (!marked[w])
                visit(w);

        }
    }

    public double mstWeight() {
        double sum = 0;
        for (WeightedEdge edge : mst) {
            sum += edge.weight();
        }
        return sum;
    }

    private void visit(int vertex) {
        marked[vertex] = true;
        for (WeightedEdge edge : originalGraph.adj(vertex)) {
            int other = edge.other(vertex);
            if (!marked[other]) {
                pq.add(edge);
            }
        }
    }
}
