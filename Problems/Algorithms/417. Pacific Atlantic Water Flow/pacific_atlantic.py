class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        def dfs(heights: List[List[int]], n: int, m: int, r: int, c: int, reachable: List[List[bool]], neighbors: List[List[int]]):
            reachable[r][c] = True

            for neighbor in neighbors:
                x, y = r + neighbor[0], c + neighbor[1]
                if x >= 0 and x < n and y >= 0 and y < m and not reachable[x][y] and heights[x][y] >= heights[r][c]:
                    dfs(heights, n, m, x, y, reachable, neighbors)

        n, m = len(heights), len(heights[0])

        neighbors = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        reachableAtlantic = [[False for _ in range(m)] for _ in range(n)]
        for c in range(m):
            dfs(heights, n, m, n-1, c, reachableAtlantic, neighbors)
        for r in range(n):
            dfs(heights, n, m, r, m-1, reachableAtlantic, neighbors)

        reachablePacific = [[False for _ in range(m)] for _ in range(n)]
        for c in range(m):
            dfs(heights, n, m, 0, c, reachablePacific, neighbors)
        for r in range(n):
            dfs(heights, n, m, r, 0, reachablePacific, neighbors)

        results = []
        for r in range(n):
            for c in range(m):
                if reachableAtlantic[r][c] and reachablePacific[r][c]:
                    results.append([r, c])

        return results

