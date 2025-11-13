package com.mateusnavarro77.algoritmos.eagerprim;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.mateusnavarro77.algoritmos.lazyprim.LazyPrim;
import com.mateusnavarro77.algoritmos.lazyprim.WeightedEdge;
import com.mateusnavarro77.algoritmos.lazyprim.WeightedUndirectedGraph;

public class PrimEagerTest {
    @Test
    public void testMST() {
        var g = new WeightedUndirectedGraph(5);
        g.addEdge(new WeightedEdge(0, 1, 4));
        g.addEdge(new WeightedEdge(0, 2, 4));
        g.addEdge(new WeightedEdge(0, 3, 6));
        g.addEdge(new WeightedEdge(0, 4, 6));
        g.addEdge(new WeightedEdge(1, 2, 2));
        g.addEdge(new WeightedEdge(2, 3, 8));
        g.addEdge(new WeightedEdge(3, 4, 9));
        int source = 4;
        var lz = new LazyPrim(g, source);
        
        var eagerPrim = new PrimEager(g, source);
        System.out.println(lz.mstWeight());
        System.out.println(eagerPrim.weight());
        assertTrue(eagerPrim.weight()==lz.mstWeight());
    }
}
