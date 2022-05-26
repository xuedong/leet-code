func allPathsSourceTarget(graph [][]int) [][]int {
    results := make([][]int, 0)
    path := make([]int, 0)

    path = append(path, 0)
    aux(graph, &results, path, 0, len(graph)-1)
    return results
}

func aux(graph [][]int, results *[][]int, path []int, src int, target int) {
    if src == target {
        *results = append(*results, append([]int{}, path...))
        return
    }

    if len(graph[src]) == 0 {
        return
    }

    for _, neighbor := range graph[src] {
        path = append(path, neighbor)
        aux(graph, results, path, neighbor, target)
        path = path[:len(path)-1]
    }
}
