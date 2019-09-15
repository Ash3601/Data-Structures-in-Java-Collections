/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topologicalordering;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Ash_360
 */
public class App {

    public static void main(String[] args) {
        TopologicalOrdering to = new TopologicalOrdering();

        List<Vertex> graph = new ArrayList<>();
        graph.add(new Vertex("0"));
        graph.add(new Vertex("1"));
        graph.add(new Vertex("2"));
        graph.add(new Vertex("3"));
        graph.add(new Vertex("4"));
        graph.add(new Vertex("5"));

        graph.get(2).addNeigbours(graph.get(3));
        graph.get(3).addNeigbours(graph.get(1));
        graph.get(4).addNeigbours(graph.get(0));
        graph.get(4).addNeigbours(graph.get(1));
        graph.get(5).addNeigbours(graph.get(0));
        graph.get(5).addNeigbours(graph.get(2));

        for (int i=0; i<graph.size(); i++) {
            if (graph.get(i).isVisited() == false) {
                to.dfs(graph.get(i));
            }
        }
        
        Stack<Vertex> stack = to.getStack();
         
        for (int i=0; i<graph.size(); i++) {
            System.out.print(stack.pop() + "->");
        }
        
//        stack.forEach((item)->System.out.print(item + ", "));
        
    }
}
