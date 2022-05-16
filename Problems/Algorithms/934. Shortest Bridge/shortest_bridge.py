from collections import deque


class Solution:
    def shortestBridge(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        neighbors = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        queue = deque()

        # transform one island using a dfs
        def dfs(i: int, j: int):
            if grid[i][j] == 1:
                queue.append((i, j, 0)) # 0 is the distance to the other island
                grid[i][j] = 2

                for neighbor in neighbors:
                    r, c = i + neighbor[0], j + neighbor[1]
                    if self.is_valid(n, m, r, c):
                        dfs(r, c)

        flag = False
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    dfs(i, j)
                    flag = True
                    break
            if flag: break

        # now find the distance using a bfs
        visited = set()
        while queue:
            i, j, dist = queue.popleft()

            if grid[i][j] == 1:
                return dist - 1
            else:
                for neighbor in neighbors:
                    r, c = i + neighbor[0], j + neighbor[1]
                    if self.is_valid(n, m, r, c):
                        if (r, c) not in visited:
                            visited.add((r, c))
                            queue.append((r, c, dist+1))

        return -1

    @staticmethod
    def is_valid(n: int, m: int, r: int, c: int) -> int:
        return r >= 0 and c >= 0 and r < n and c < m

