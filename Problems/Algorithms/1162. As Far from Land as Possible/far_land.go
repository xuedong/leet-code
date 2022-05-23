func maxDistance(grid [][]int) int {
    n, m := len(grid), len(grid[0])

    visited := make([][]bool, n)
    for row := range visited {
        visited[row] = make([]bool, m)
    }

    neighbors := [4][2]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}

    queue := make([][2]int, 0)
    for i := 0; i < n; i++ {
        for j := 0; j < m; j++ {
            if grid[i][j] == 1 {
                queue = append(queue, [2]int{i, j})
            }
        }
    }

    ans := -1
    for len(queue) > 0 {
        size := len(queue)
        for i := 1; i <= size; i++ {
            curr := queue[0]
            queue = queue[1:]

            for _, neighbor := range neighbors {
                r, c := curr[0] + neighbor[0], curr[1] + neighbor[1]
                if isValid(n, m, r, c) && !visited[r][c] && grid[r][c] == 0 {
                    visited[r][c] = true
                    queue = append(queue, [2]int{r, c})
                }
            }
        }
        ans++
    }

    if ans <= 0 {
        return -1
    }
    return ans
}

func isValid(n int, m int, r int, c int) bool {
    return r >= 0 && r < n && c >= 0 && c < m
}
