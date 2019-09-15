/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycledetectiondfs;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        Vertex v6 = new Vertex("6");

        v1.addNeighbour(v2);
        v1.addNeighbour(v3);
        v2.addNeighbour(v3);
        v4.addNeighbour(v1);
        v4.addNeighbour(v5);
        v5.addNeighbour(v6);
        v6.addNeighbour(v4);

        List<Vertex> vertices = new ArrayList<>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        
        CycleDetectionDFS cyd = new CycleDetectionDFS();
        cyd.detectCycles(vertices);

    }

}
