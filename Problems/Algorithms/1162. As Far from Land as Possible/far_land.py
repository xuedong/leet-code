class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
    
        visited = [[False for _ in range(m)] for _ in range(n)]
        neighbors = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    
        queue = []
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    queue.append((i, j))
    
        ans = -1
        while queue:
            size = len(queue)
            for _ in range(size):
                curr = queue.pop(0)
                
                for neighbor in neighbors:
                    r, c = curr[0] + neighbor[0], curr[1] + neighbor[1]
                    if r >= 0 and r < n and c >= 0 and c < m and not visited[r][c] and grid[r][c] == 0:
                        visited[r][c] = True
                        queue.append((r, c))

            ans += 1
    
        return -1 if ans <= 0 else ans
