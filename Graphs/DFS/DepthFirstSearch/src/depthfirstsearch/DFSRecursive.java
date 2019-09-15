/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package depthfirstsearch;

/**
 *
 * @author Ash_360
 */
public class DFSRecursive {
    public void dfsRecursive(Vertex vertex) {
        vertex.setVisited(true);
        System.out.println("Vertex " + vertex); 
        
        for (Vertex v : vertex.getNeighbourList()) {
            if (v.isVisited() == false) {
                dfsRecursive(v);
            }
        }
    }
}
