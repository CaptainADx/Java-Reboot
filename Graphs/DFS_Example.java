import java.util.*;

public class DFS_Example {

    static void dfs(int node, boolean[] visited, ArrayList<Integer>[] adj) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj);
            }
        }
    }

    public static void main(String[] args) {
        int V = 8;

        // Edge list (with cycles + disconnected)
        int[][] edges = {
            {0,1}, {1,2}, {2,0},   // Cycle 1
            {2,3},                 // Bridge
            {3,4}, {4,5}, {5,3},   // Cycle 2
            {6,7}                  // Separate component
        };

        // Step 1: Create adjacency list
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[V];
        
        //Filling the array with empty ArrayList
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Step 2: Convert edge list → adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u); // undirected
        }

        boolean[] visited = new boolean[V];

        System.out.println("DFS Traversal of Graph:");

        // Handles disconnected graph also
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj);
            }
        }
    }
}