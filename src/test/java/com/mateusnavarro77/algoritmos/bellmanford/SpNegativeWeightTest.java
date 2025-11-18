package com.mateusnavarro77.algoritmos.bellmanford;

import org.junit.Test;

import com.mateusnavarro77.algoritmos.dijkstra.HelperGraphBuilder;
import com.mateusnavarro77.algoritmos.dijkstra.WeightedEdge;

public class SpNegativeWeightTest {
    @Test
    public void testBellmanFord(){
        var testGraph = HelperGraphBuilder.buildLargeGraph();
        SpNegativeWeight sp = new SpNegativeWeight(testGraph, 35);
        
        System.out.println(sp.distTo(19));
        var iterable = sp.pathTo(19);
        for (WeightedEdge weightedEdge : iterable) {
            System.out.println(weightedEdge.from());
        }
    }
}
