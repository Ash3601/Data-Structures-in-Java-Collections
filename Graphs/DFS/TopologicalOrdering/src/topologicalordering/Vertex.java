/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topologicalordering;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ash_360
 */
public class Vertex {
    private String vertexName;
    private List<Vertex> neighboursList;
    private boolean visited;

    public Vertex(String vertexName) {
        this.vertexName = vertexName;
        this.neighboursList = new ArrayList<>();
    }
    
    // add neighbours
    public void addNeigbours(Vertex vertex) {
        this.neighboursList.add(vertex);
    }

    public String getVertexName() {
        return vertexName;
    }

    public List<Vertex> getNeighboursList() {
        return neighboursList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVertexName(String vertexName) {
        this.vertexName = vertexName;
    }

    public void setNeighboursList(List<Vertex> neighboursList) {
        this.neighboursList = neighboursList;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return this.vertexName;
    }
    
    
}
