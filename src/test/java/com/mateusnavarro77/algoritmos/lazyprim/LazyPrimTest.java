package com.mateusnavarro77.algoritmos.lazyprim;

import java.util.Arrays;

import org.junit.Test;

public class LazyPrimTest {

    @Test
    public void testLazyPrim() {
        var g = new WeightedUndirectedGraph(5);
        g.addEdge(new WeightedEdge(0, 1, 4));
        g.addEdge(new WeightedEdge(0, 2, 4));
        g.addEdge(new WeightedEdge(0, 3, 6));
        g.addEdge(new WeightedEdge(0, 4, 6));
        g.addEdge(new WeightedEdge(1, 2, 2));
        g.addEdge(new WeightedEdge(2, 3, 8));
        g.addEdge(new WeightedEdge(3, 4, 9));
        var lz = new LazyPrim(g, 0);
        System.out.println(Arrays.toString(lz.marked));
        System.out.println(lz.mst);
        System.out.println(lz.pq);
    }
}
