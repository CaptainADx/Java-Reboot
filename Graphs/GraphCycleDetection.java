import java.util.*;

public class GraphCycleDetection {

    // Function to detect cycle in undirected graph using DFS
    public static boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) {
                    return true;
                }
            } 
            else if (neighbor != parent) {
                return true; // cycle detected
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (undirected)
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 4);
        addEdge(adj, 4, 3);
        addEdge(adj, 3, 1); // This creates a cycle

        boolean hasCycle = isCycle(V, adj);

        if (hasCycle) {
            System.out.println("Cycle detected!");
        } else {
            System.out.println("No cycle.");
        }
    }

    // Helper to add undirected edge
    private static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}