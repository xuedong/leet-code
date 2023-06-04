func findCircleNum(isConnected [][]int) int {
    n := len(isConnected)
    neighbors := make(map[int][]int)
    for i := 0; i < n; i++ {
        for j := i+1; j < n; j++ {
            if isConnected[i][j] == 1 {
                neighbors[i] = append(neighbors[i], j)
                neighbors[j] = append(neighbors[j], i)
            }
        }
    }

    visited := make([]bool, n)

    ans := 0
    for i := 0; i < n; i++ {
        if !visited[i] {
            ans++
            dfs(i, neighbors, visited)
        }
    }

    return ans
}

func dfs(start int, neighbors map[int][]int, visited []bool) {
    visited[start] = true

    for _, neighbor := range neighbors[start] {
        if !visited[neighbor] {
            dfs(neighbor, neighbors, visited)
        }
    }
}
