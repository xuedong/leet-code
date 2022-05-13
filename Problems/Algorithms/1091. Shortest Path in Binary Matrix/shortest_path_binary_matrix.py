class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])

        if grid[0][0] == 1 or grid[n-1][m-1] == 1:
            return -1

        visited = [[False for _ in range(m)] for _ in range(n)]
        neighbors = [[0, 1], [0, -1], [1, 0], [-1, 0], [1, 1], [1, -1], [-1, 1], [-1, -1]]

        queue = []
        queue.append([0, 0, 1])
        visited[0][0] = True

        while queue:
            r, c, length = queue.pop(0)

            if r == n-1 and c == m-1:
                return length

            for neighbor in neighbors:
                x, y = r + neighbor[0], c + neighbor[1]
                if self.is_valid(n, m, x, y) and not visited[x][y] and grid[x][y] == 0:
                    queue.append([x, y, length+1])
                    visited[x][y] = True

        return -1

    @staticmethod
    def is_valid(n: int, m: int, r: int, c: int) -> bool:
        return r >= 0 and r < n and c >= 0 and c < m

