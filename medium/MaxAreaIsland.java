class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == 1) {

                    int area = dfs(grid, row, col);

                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == 0) {

            return 0;
        }

        grid[row][col] = 0;

        int count = 1;

      
        count += dfs(grid, row - 1, col);
        count += dfs(grid, row + 1, col); 
        count += dfs(grid, row, col - 1); 
        count += dfs(grid, row, col + 1); 

        return count;
    }
}