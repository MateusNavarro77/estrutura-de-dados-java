package com.mateusnavarro77.algoritmos.dijkstra;

import org.junit.Test;

public class SpTest {

    @Test
    public void testDijkstra(){
        DirectedWeightedGraph g = HelperGraphBuilder.buildLargeGraph();
        
        Sp sp = new Sp(g, 0);
        
        System.out.println(sp.distTo(58));
        var i = sp.pathTo(58);
        for (WeightedEdge weightedEdge : i) {
            System.out.println(weightedEdge.from());
        }

    }
}
