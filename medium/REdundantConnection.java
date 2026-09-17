import java.utils.*;
class Solution {

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        // Graph
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Process each edge
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            // Check: kya u se v already connected hai?
            boolean[] visited = new boolean[n + 1];

            if (hasPath(u, v, graph, visited)) {
                return edge;
            }

            // Agar connected nahi hain,
            // toh edge graph mein add kar do
            graph[u].add(v);
            graph[v].add(u);
        }

        return new int[0];
    }


    private boolean hasPath(int current,
                            int target,
                            ArrayList<Integer>[] graph,
                            boolean[] visited) {

        // Destination mil gaya
        if (current == target) {
            return true;
        }

        visited[current] = true;

        // Saare neighbours check karo
        for (int neighbour : graph[current]) {

            if (!visited[neighbour]) {

                if (hasPath(neighbour, target, graph, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}