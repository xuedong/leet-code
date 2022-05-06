class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        n, m = len(grid), len(grid[0])
        visited = [[False for _ in range(m)] for _ in range(n)]
        neighbors = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        ans = 0
        for i in range(n):
            for j in range(m):
                if not visited[i][j] and grid[i][j] == '1':
                    ans += 1

                    queue = []
                    queue.append([i, j])

                    while queue:
                        for _ in range(len(queue)):
                            row, col = queue.pop(0)
                            for neighbor in neighbors:
                                x, y = row + neighbor[0], col + neighbor[1]
                                if x >= 0 and y >= 0 and x < n and y < m and grid[x][y] == '1' and not visited[x][y]:
                                    visited[x][y] = True
                                    queue.append([x, y])

        return ans

