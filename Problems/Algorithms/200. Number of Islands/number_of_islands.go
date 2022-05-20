func numIslands(grid [][]byte) int {
    n := len(grid)
    m := len(grid[0])

    ans := 0
    for i := 0; i < n; i++ {
        for j := 0; j < m; j++ {
            ans += dfs(grid, n, m, i, j)
        }
    }

    return ans
}

func isValid(n int, m int, i int, j int) bool {
    return i >= 0 && i < n && j >= 0 && j < m
}

func dfs(grid [][]byte, n int, m int, i int, j int) int {
    if !isValid(n, m, i, j) || grid[i][j] == '0' {
        return 0
    }

    grid[i][j] = '0'

    dfs(grid, n, m, i+1, j)
    dfs(grid, n, m, i-1, j)
    dfs(grid, n, m, i, j+1)
    dfs(grid, n, m, i, j-1)

    return 1
}
