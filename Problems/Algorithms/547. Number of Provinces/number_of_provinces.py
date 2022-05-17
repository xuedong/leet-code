from collections import defaultdict


class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        neighbors = defaultdict(list)
        for i in range(n):
            for j in range(i+1, n):
                if isConnected[i][j] == 1:
                    neighbors[i].append(j)
                    neighbors[j].append(i)

        visited = [False for _ in range(n)]

        def dfs(start: int, neighbors: Dict[int, List[int]], visited: List[int]):
            visited[start] = True

            for neighbor in neighbors[start]:
                if not visited[neighbor]:
                    dfs(neighbor, neighbors, visited)

        ans = 0
        for i in range(n):
            if not visited[i]:
                ans += 1
                dfs(i, neighbors, visited)

        return ans

