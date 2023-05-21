class Solution {
    private List<int[]> queue;

    private boolean isValid(int x, int y, int n) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    private void dfs(int[][] grid, int x, int y, int n) {
        grid[x][y] = 2;
        queue.add(new int[]{x, y});

        for (int[] neighbor : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
            int currX = neighbor[0], currY = neighbor[1];
            if (isValid(currX, currY, n) && grid[currX][currY] == 1) {
                dfs(grid, currX, currY, n);
            }
        }
    }

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int startX = -1, startY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }

        queue = new ArrayList<>();
        dfs(grid, startX, startY, n);

        int ans = 0;
        while (!queue.isEmpty()) {
            List<int[]> curr = new ArrayList<>();
            for (int[] node : queue) {
                int x = node[0], y = node[1];
                for (int[] neighbor : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
                    int currX = neighbor[0], currY = neighbor[1];
                    if (isValid(currX, currY, n)) {
                        if (grid[currX][currY] == 1) {
                            return ans;
                        } else if (grid[currX][currY] == 0) {
                            curr.add(neighbor);
                            grid[currX][currY] = -1;
                        }
                    }
                }
            }

            queue = curr;
            ans++;
        }

        return ans;
    }
}
