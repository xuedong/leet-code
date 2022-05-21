func closedIsland(grid [][]int) int {
    n, m := len(grid), len(grid[0])

    visited := make([][]int, n)
    for row := range visited {
        visited[row] = make([]int, m)
    }

    ans := 0
    for r := 0; r < n; r++ {
        for c := 0; c < m; c++ {
            curr := dfs(grid, visited, n, m, r, c)
            if curr > 0 {
                ans++
            }
        }
    }

    return ans
}

func isValid(n int, m int, r int, c int) bool {
    return r >= 0 && r < n && c >= 0 && c < m
}

func isCorner(n int, m int, r int, c int) bool {
    return r == 0 || c == 0 || r == n-1 || c == m-1
}

func dfs(grid [][]int, visited [][]int, n int, m int, r int, c int) int {
    if !isValid(n, m, r, c) || visited[r][c] == 1 || grid[r][c] == 1 {
        return 0
    }
    if isCorner(n, m, r, c) {
        return -1000
    }

    visited[r][c] = 1
    return 1 + dfs(grid, visited, n, m, r+1, c) + dfs(grid, visited, n, m, r-1, c) + dfs(grid, visited, n, m, r, c+1) + dfs(grid, visited, n, m, r, c-1)
}
