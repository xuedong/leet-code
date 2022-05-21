func maxAreaOfIsland(grid [][]int) int {
    n, m := len(grid), len(grid[0])

    visited := make([][]int, n)
    for row := range visited {
        visited[row] = make([]int, m)
    }
    neighbors := [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}

    best := 0
    for r := 0; r < n; r++ {
        for c := 0; c < m; c++ {
            best = max(best, dfs(grid, visited, neighbors, n, m, r, c))
        }
    }

    return best
}

func dfs(grid [][]int, visited [][]int, neighbors [][]int, n int, m int, r int, c int) int {
    if !isValid(n, m, r, c) || visited[r][c] == 1 || grid[r][c] == 0 {
        return 0
    }

    visited[r][c] = 1

    ans := 1
    for _, neighbor := range neighbors {
        ans += dfs(grid, visited, neighbors, n, m, r+neighbor[0], c+neighbor[1])
    }

    return ans
}

func isValid(n int, m int, r int, c int) bool {
    return r >= 0 && r < n && c >= 0 && c < m
}

func max(x, y int) int {
    if x > y {
        return x
    }
    return y
}
