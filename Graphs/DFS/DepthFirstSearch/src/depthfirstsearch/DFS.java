/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depthfirstsearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFS {

    private Stack<Vertex> stack = new Stack<>();

    public void dfs(List<Vertex> vertexList) {
        // if we have several clusters instead of just one then we need to have our for loop

        for (Vertex v : vertexList) {
            if (!v.isVisited()) {
                v.setVisited(true);
                dfsWithStack(v);
            }
        }
    }

    public void dfsRecursion(List<Vertex> vertexList) {
        // if we have several clusters instead of just one then we need to have our for loop
        for (Vertex v : vertexList) {
            if (!v.isVisited()) {
                v.setVisited(true);
                dfsRecursive(v);
            }
        }
    }

    private void dfsRecursive(Vertex vertex) {
        vertex.setVisited(true);

        System.out.print(" " + vertex);

        for (Vertex v : vertex.getNeighbourList()) {
            if (!v.isVisited()) {
                dfsRecursive(v);
            }
        }
    }

    private void dfsWithStack(Vertex root) {
//        Stack<Vertex> stack = new Stack<>();
//        System.out.println("In dfsWithStack method");
        stack.add(root);
        root.setVisited(true);

        // pop element out of stack and check if its empty
        while (!stack.isEmpty()) {
            Vertex poppedNode = stack.pop();
            System.out.print(poppedNode + " ");

            for (Vertex v : poppedNode.getNeighbourList()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    stack.push(v);
                }

            }
        }
    }
}
