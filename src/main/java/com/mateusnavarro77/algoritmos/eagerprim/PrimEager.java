package com.mateusnavarro77.algoritmos.eagerprim;

import java.util.LinkedList;
import java.util.Queue;

import com.mateusnavarro77.algoritmos.lazyprim.WeightedEdge;
import com.mateusnavarro77.algoritmos.lazyprim.WeightedUndirectedGraph;

public class PrimEager {
    private final WeightedUndirectedGraph originalGraph;
    private final boolean[] marked;
    private final WeightedEdge[] edgeTo;
    private final double[] distTo;
    private final IndexMinPQ<Double> pq;

    public PrimEager(WeightedUndirectedGraph graph, int source) {
        this.originalGraph = graph;
        marked = new boolean[graph.V()];
        edgeTo = new WeightedEdge[graph.V()];
        distTo = new double[graph.V()];
        pq = new IndexMinPQ<Double>(graph.V());
        for (int i = 0; i < graph.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        distTo[source] = 0.0;
        pq.insert(source, 0.0);

        while (!pq.isEmpty()) {
            int currentVertex = pq.delMin();
            visit(currentVertex);
        }
    }

    private void visit(int v) {
        marked[v] = true;
        for (WeightedEdge incidentEdge : originalGraph.adj(v)) {
            int w = incidentEdge.other(v);
            if (marked[w])
                continue; // Ignore marked
            double edgeWeight = incidentEdge.weight();
            if (edgeWeight < distTo[w]) {
                distTo[w] = edgeWeight;
                edgeTo[w] = incidentEdge;
                if (pq.contains(w)) {
                    pq.decreaseKey(w, edgeWeight);
                } else {
                    pq.insert(w, edgeWeight);
                }
            }
        }
    }

    public Iterable<WeightedEdge> edges() {
        Queue<WeightedEdge> mst = new LinkedList<>();
        for (int v = 0; v < originalGraph.V(); v++) {
            if (edgeTo[v] != null)
                mst.add(edgeTo[v]);
        }
        return mst;
    }

    public double weight() {
        double sum = 0.0;
        for (WeightedEdge e : edges())
            sum += e.weight();
        return sum;
    }
}
