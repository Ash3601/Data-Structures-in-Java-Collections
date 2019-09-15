/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycledetectiondfs;

import java.util.List;

/**
 *
 * @author Ash_360
 */
public class CycleDetectionDFS {

    public void detectCycles(List<Vertex> vertexList) {
        for (Vertex v : vertexList) {
            if (v.isVisited() == false) {
                dfs(v);
            }
        }
    }

    private void dfs(Vertex vertex) {
        
        System.out.println("DFS on vertex " + vertex );
        vertex.setBeingVisited(true);

        for (Vertex v : vertex.getNeighbourList()) {
            
            System.out.println("Visiting neighbours of vertex " + vertex );
            
            if (v.isBeingVisited()== true) {
                System.out.println("Backward edge found!! Thus a cycle is found.");
                return;
            }

            if (v.isVisited() == false) {
                System.out.println("Visting vertex " + v + " recursively...");
                v.setVisited(true);
                dfs(v);
            }
        }
        System.out.println("Set vertex " + vertex + " setBeingVisited(false) and visited(true)...");
        // so ab vertex visit kiya nahi ja rha
        // thus set visited to false
        vertex.setBeingVisited(false);
        vertex.setVisited(true);
        
    }

}
