package com.mateusnavarro77.algoritmos.dijkstra;

import org.junit.Test;

public class DirectedWeightedGraphTest {
    @Test
    public void testAddEdge() {
        var g = new DirectedWeightedGraph(10);
        g.addEdge(new WeightedEdge(0, 9, 0.23));
        g.addEdge(new WeightedEdge(0, 8, 0.28));
        g.addEdge(new WeightedEdge(2, 3, 0.73));
        System.out.println(g.adj(3));
    }
}
