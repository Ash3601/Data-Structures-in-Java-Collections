
package topologicalordering;

import java.util.Stack;

/**
 *
 * @author Ash_360
 */
public class TopologicalOrdering {

    private Stack<Vertex> stack;
    
    public TopologicalOrdering() {
        stack = new Stack<Vertex>();
    }

    
    public void dfs(Vertex vertex) {
        vertex.setVisited(true);
        
        for (Vertex v : vertex.getNeighboursList()) {
            if (!v.isVisited())
                dfs(v);
        }
        
        stack.push(vertex);
    }
    
    public Stack<Vertex> getStack() {
        return this.stack;
    }
    
    
}
