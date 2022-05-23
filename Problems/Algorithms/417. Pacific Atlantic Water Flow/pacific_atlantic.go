func pacificAtlantic(heights [][]int) [][]int {
    n, m := len(heights), len(heights[0])

    visited := make([][]bool, n)
    for row := range visited {
        visited[row] = make([]bool, m)
    }

    neighbors := [4][2]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}

    reachableAtlantic := make([][]bool, n)
    for row := range reachableAtlantic {
        reachableAtlantic[row] = make([]bool, m)
    }
    for c := 0; c < m; c++ {
        dfs(heights, n, m, n-1, c, reachableAtlantic, neighbors)
    }
    for r := 0; r < n; r++ {
        dfs(heights, n, m, r, m-1, reachableAtlantic, neighbors)
    }

    reachablePacific := make([][]bool, n)
    for row := range reachablePacific {
        reachablePacific[row] = make([]bool, m)
    }
    for c := 0; c < m; c++ {
        dfs(heights, n, m, 0, c, reachablePacific, neighbors)
    }
    for r := 0; r < n; r++ {
        dfs(heights, n, m, r, 0, reachablePacific, neighbors)
    }

    results := make([][]int, 0)
    for r := 0; r < n; r++ {
        for c := 0; c < m; c++ {
            if reachableAtlantic[r][c] && reachablePacific[r][c] {
                results = append(results, []int{r, c})
            }
        }
    }

    return results
}

func dfs(heights [][]int, n int, m int, r int, c int, reachable [][]bool, neighbors [4][2]int) {
    reachable[r][c] = true

    for _, neighbor := range neighbors {
        x := r + neighbor[0]
        y := c + neighbor[1]
        if isValid(n, m, x, y) && !reachable[x][y] && heights[x][y] >= heights[r][c] {
            dfs(heights, n, m, x, y, reachable, neighbors)
        }
    }
}


func isValid(n int, m int, r int, c int) bool {
    return r >= 0 && r < n && c >= 0 && c < m
}
