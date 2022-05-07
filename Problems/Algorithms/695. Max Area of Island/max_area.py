class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        visited = [[0 for _ in range(m)] for _ in range(n)]
        neighbors = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        def dfs(grid: List[List[int]], visited: List[List[int]], r: int, c: int) -> int:
            if not self.is_valid(n, m, r, c) or visited[r][c] == 1 or grid[r][c] == 0:
                return 0

            visited[r][c] = 1
            ans = 1
            for neighbor in neighbors:
                ans += dfs(grid, visited, r+neighbor[0], c+neighbor[1])
            return ans

        best = 0
        for r in range(n):
            for c in range(m):
                best = max(best, dfs(grid, visited, r, c))
        return best

    @staticmethod
    def is_valid(n: int, m: int, r: int, c: int) -> bool:
        return r >= 0 and c >= 0 and r < n and c < m

