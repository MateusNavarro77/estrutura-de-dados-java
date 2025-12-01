package com.mateusnavarro77.algoritmos.fordfulkerson;

import java.util.LinkedList;
import java.util.Queue;

import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;

public class FordFulkerson {

    private boolean[] marked;
    private FlowEdge[] backtrackEdge;
    private double maxFlowValue;

    public double getMaxFlowValue() {
        return maxFlowValue;
    }

    public FordFulkerson(FlowNetwork g, int source, int sink) {

        while (hasAugmentingPath(g, source, sink)) {
            double bottleNeck = Double.POSITIVE_INFINITY;
            for (int v = sink; v != source; v = backtrackEdge[v].other(v)) {
                bottleNeck = Math.min(bottleNeck, backtrackEdge[v].residualCapacityTo(v));
            }
            for (int v = sink; v != source; v = backtrackEdge[v].other(v)) {
                backtrackEdge[v].addResidualFlowTo(v, bottleNeck);
            }
            maxFlowValue += bottleNeck;

        }

    }

    private boolean hasAugmentingPath(FlowNetwork g, int source, int sink) {
        marked = new boolean[g.V()];
        backtrackEdge = new FlowEdge[g.V()];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        marked[source] = true;
        while (!q.isEmpty() && !marked[sink]) {
            int current = q.poll();
            for (FlowEdge edge : g.adj(current)) {
                int w = edge.other(current);
                if (edge.residualCapacityTo(w) > 0) { // Entra no if se a aresta não está saturada
                    if (!marked[w]) {
                        q.add(w);
                        marked[w] = true;
                        backtrackEdge[w] = edge;
                    }
                }
            }
        }
        return marked[sink];

    }

    // private boolean hasAugmentingPath()

}