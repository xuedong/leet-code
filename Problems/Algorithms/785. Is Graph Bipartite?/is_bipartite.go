func isBipartite(graph [][]int) bool {
    visited := make(map[int]int)

    for i := 0; i < len(graph); i++ {
        if _, ok := visited[i]; !ok && !dfs(graph, i, 1, visited) {
            return false
        }
    }
    return true
}

func dfs(graph [][]int, i int, part int, visited map[int]int) bool {
    if val, ok := visited[i]; ok {
        return val == part
    }

    visited[i] = part

    for _, j := range graph[i] {
        if !dfs(graph, j, -part, visited) {
            return false
        }
    }
    return true
}
