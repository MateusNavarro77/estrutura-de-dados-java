package com.mateusnavarro77.algoritmos.bellmanford;

import java.util.Stack;

import com.mateusnavarro77.algoritmos.dijkstra.DirectedWeightedGraph;
import com.mateusnavarro77.algoritmos.dijkstra.WeightedEdge;

public class SpNegativeWeight {
    private double[] distTo;
    private WeightedEdge[] parentEdge;
    private boolean hasNegativeCycle = false;

    public SpNegativeWeight(DirectedWeightedGraph g, int source) {

        distTo = new double[g.V()];
        parentEdge = new WeightedEdge[g.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[source] = 0;

        for (int pass = 0; pass < g.V(); pass++) {
            boolean updated = false;

            for (int v = 0; v < g.V(); v++) {
                for (WeightedEdge edge : g.adj(v)) {
                    if (relax(edge)) {
                        updated = true;
                    }
                }
            }

            if (pass == g.V() - 1 && updated) {
                hasNegativeCycle = true;
            }
        }
    }

    public boolean hasNegativeCycle() {
        return hasNegativeCycle;
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public Iterable<WeightedEdge> pathTo(int v) {
        if (hasNegativeCycle) {
            throw new IllegalStateException(
                    "Shortest path undefined: graph contains a negative-weight cycle.");
        }

        Stack<WeightedEdge> s = new Stack<>();
        WeightedEdge current = parentEdge[v];
        while (current != null) {
            s.push(current);
            current = parentEdge[current.from()];
        }
        return s;
    }

    private boolean relax(WeightedEdge edge) {
        int v = edge.from();
        int w = edge.to();

        if (distTo[v] == Double.POSITIVE_INFINITY) {
            return false;
        }

        double candidate = distTo[v] + edge.weight();

        if (candidate < distTo[w]) {
            distTo[w] = candidate;
            parentEdge[w] = edge;
            return true;
        }

        return false;
    }
}
