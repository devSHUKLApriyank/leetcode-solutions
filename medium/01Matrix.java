class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

       
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (mat[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }

       
        int[][] directions = {
            {-1, 0},  
            {1, 0},   
            {0, -1},  
            {0, 1}   
        };

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

            
                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols &&
                    !visited[nr][nc]) {

                    mat[nr][nc] = mat[r][c] + 1;

                    visited[nr][nc] = true;

                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return mat;
    }
}