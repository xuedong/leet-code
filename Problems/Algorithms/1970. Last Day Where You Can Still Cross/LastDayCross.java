class Solution {
    private int[][] neighbors = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private boolean canCross(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 0) {
                queue.offer(new int[]{0, i});
                grid[0][i] = -1;
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0], currY = curr[1];

            if (currX == row - 1) {
                return true;
            }

            for (int[] neighbor : neighbors) {
                int nextX = currX + neighbor[0], nextY = currY + neighbor[1];
                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && grid[nextX][nextY] == 0) {
                    grid[nextX][nextY] = -1;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0, right = row * col;

        while (right - left > 1) {
            int mid = right - (right - left) / 2;
            if (canCross(row, col, cells, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
