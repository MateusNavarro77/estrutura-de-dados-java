package com.mateusnavarro77.algoritmos.dijkstra;

import java.util.Stack;

import com.mateusnavarro77.algoritmos.eagerprim.IndexMinPQ;

public class Sp {

    private double[] distTo;
    private WeightedEdge[] parentEdge;
    private IndexMinPQ<Double> pq;

    public Sp(DirectedWeightedGraph graph, int source) {
        distTo = new double[graph.V()];
        parentEdge = new WeightedEdge[graph.V()];
        pq = new IndexMinPQ<Double>(graph.V());
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[source] = 0.0;
        pq.insert(source, 0.0);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (WeightedEdge adjacent : graph.adj(v)) {
                relax(adjacent);
            }
        }
        // Enfileirar a fonte source com prioridade 0.0
        // Enquanto fila nao vazia. Desenfileirar o vertice escolhido.
        // Varrer os adjacentes do vertice escolhido e relaxar cada um deles

    }

    public Iterable<WeightedEdge> pathTo(int v) {
        Stack<WeightedEdge> s = new Stack<>();

        WeightedEdge currentParent = parentEdge[v];
        while (currentParent != null) {
            s.push(currentParent);
            currentParent = parentEdge[currentParent.from()];
        }
        return s;
    }

    public double distTo(int v) {
        return distTo[v];
    }

    private void relax(WeightedEdge edge) {
        int v = edge.from();
        int w = edge.to();

        double currentDistanceToW = distTo[w];
        double distanceCandidateToW = distTo[v] + edge.weight();
        if (distanceCandidateToW < currentDistanceToW) {
            distTo[w] = distanceCandidateToW;
            parentEdge[w] = edge;
            // Reconfigurar fila
            if (pq.contains(w)) {
                pq.decreaseKey(w, distanceCandidateToW);
            } else {
                pq.insert(w, distanceCandidateToW);
            }
        }

    }

}
