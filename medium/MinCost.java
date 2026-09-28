class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        boolean[] visited = new boolean[n];

        int[] minDist = new int[n];

        // Initially sabki distance infinity
        Arrays.fill(minDist, Integer.MAX_VALUE);

        // Point 0 se start
        minDist[0] = 0;

        int totalCost = 0;

        for (int count = 0; count < n; count++) {

            // Minimum distance wala unvisited point find karo
            int current = -1;

            for (int i = 0; i < n; i++) {

                if (!visited[i] &&
                    (current == -1 || minDist[i] < minDist[current])) {

                    current = i;
                }
            }

            // Point ko MST mein add karo
            visited[current] = true;

            totalCost += minDist[current];

            // Current point se baaki points ki distance update karo
            for (int next = 0; next < n; next++) {

                if (!visited[next]) {

                    int distance =
                        Math.abs(points[current][0] - points[next][0])
                        + Math.abs(points[current][1] - points[next][1]);

                    if (distance < minDist[next]) {
                        minDist[next] = distance;
                    }
                }
            }
        }

        return totalCost;
    }
}