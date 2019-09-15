/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycledetectiondfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String vertexName;
    private boolean visited;
    private boolean beingVisited;
    private List<Vertex> neighbourList;

    public boolean isBeingVisited() {
        return beingVisited;
    }

    @Override
    public String toString() {
        return this.vertexName;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    public String getVertexName() {
        return vertexName;
    }

    public void setVertexName(String vertexName) {
        this.vertexName = vertexName;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbourList() {
        return neighbourList;
    }

    public void setNeighbourList(List<Vertex> neighbourList) {
        this.neighbourList = neighbourList;
    }
    
    // add neighbour
    public void addNeighbour(Vertex vertex) {
        this.neighbourList.add(vertex);
    }
    
    // constructor
    public Vertex(String vertexName) {
        this.vertexName = vertexName;
        this.neighbourList = new ArrayList<>();
    }

}
