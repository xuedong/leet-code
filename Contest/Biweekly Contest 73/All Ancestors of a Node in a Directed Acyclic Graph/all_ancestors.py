class Solution:
    def getAncestors(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        def visit(dag, vertex, visited):
            if vertex in visited: 
                return visited[vertex]

            ancestors = set()
            if vertex in dag:
                for ancestor in dag[vertex]:
                    ancestors.add(ancestor)
                    ancestors.update(visit(dag, ancestor, visited))

            visited[vertex] = ancestors
            return list(ancestors)

        dag = {}
        for ancestor, descendant in edges:
            if descendant not in dag:
                dag[descendant] = [ancestor]
            else:
                dag[descendant].append(ancestor)

        visited = {}
        results = [[] for _ in range(n)]
        for vertex in dag:
            results[vertex] = visit(dag, vertex, visited)

        return results

