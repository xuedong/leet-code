class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        visited = {}

        def dfs(i: int, part: int, visited: Dict[int, int]) -> bool:
            if i in visited:
                return visited[i] == part
            visited[i] = part

            return all([dfs(it, -part, visited) for it in graph[i]])

        return all([it in visited or dfs(it, 1, visited) for it in range(len(graph))])

