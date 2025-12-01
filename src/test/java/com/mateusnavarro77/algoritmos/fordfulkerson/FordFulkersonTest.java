package com.mateusnavarro77.algoritmos.fordfulkerson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;

public class FordFulkersonTest {
    @Test
    public void testGetMaxFlowValue() {

        FlowNetwork f = new FlowNetwork(6);

        // Source = 0, Sink = 5
        // Adding edges: FlowEdge(from, to, capacity)
        f.addEdge(new FlowEdge(0, 1, 10.0));
        f.addEdge(new FlowEdge(0, 2, 10.0));
        f.addEdge(new FlowEdge(1, 2, 2.0));
        f.addEdge(new FlowEdge(1, 3, 4.0));
        f.addEdge(new FlowEdge(1, 4, 8.0));
        f.addEdge(new FlowEdge(2, 4, 9.0));
        f.addEdge(new FlowEdge(3, 5, 10.0));
        f.addEdge(new FlowEdge(4, 3, 6.0));
        f.addEdge(new FlowEdge(4, 5, 10.0));

        FordFulkerson ff = new FordFulkerson(f, 0, 5);

        // Expected max flow is 19.0
        assertEquals(19.0, ff.getMaxFlowValue(), 0.001);
    }
    @Test
    public void edgeSaturationTests(){
        int v = 1;
        int w = 3;
        int cap = 10;
        FlowEdge e = new FlowEdge(v,w,cap);
        assertTrue(e.flow()==0.0);
        assertTrue(e.residualCapacityTo(w)==10.0);
        e.addResidualFlowTo(w, 2.0);
        assertTrue(e.flow()==2.0); //Fluxo atual
        assertTrue(e.residualCapacityTo(w)==8.0); // v -> w falta encher 8 de v para w
        assertTrue(e.residualCapacityTo(v)==2.0); // da pra tirar 2 voltando pra V (já encheu 2)
        assertTrue(e.residualCapacityTo(v)==2.0);

    }
}
