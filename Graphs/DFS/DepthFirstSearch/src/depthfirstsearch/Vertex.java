
package depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private boolean visited;
    private List<Vertex> neighbourList;

    public Vertex(String name) {
        this.name = name;
        this.neighbourList = new ArrayList<>();
    }
    
    // add neighbour 
    public void addNeighbour(Vertex vertex) {
        this.neighbourList.add(vertex);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public List<Vertex> getNeighbourList() {
        return neighbourList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setNeighbourList(List<Vertex> neighbourList) {
        this.neighbourList = neighbourList;
    }
    
    
}
