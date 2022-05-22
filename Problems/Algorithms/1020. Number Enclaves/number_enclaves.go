func numEnclaves(grid [][]int) int {
    n, m := len(grid), len(grid[0])

    visited := make([][]bool, n)
    for row := range visited {
        visited[row] = make([]bool, m)
    }

    neighbors := [4][2]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}

    ans := 0
    for i := 0; i < n; i++ {
        for j := 0; j < m; j++ {
            if !visited[i][j] && grid[i][j] == 1 {
                flag := false
                count := 0
                queue := make([][2]int, 0)
                queue = append(queue, [2]int{i, j})

                for len(queue) > 0 {
                    for k := 0; k < len(queue); k++ {
                        curr := queue[0]
                        queue = queue[1:]
                        r, c := curr[0], curr[1]
                        count++

                        visited[r][c] = true
                        for _, neighbor := range neighbors {
                            x, y := r + neighbor[0], c + neighbor[1]
                            if !isValid(n, m, x, y) {
                                flag = true
                                continue
                            }

                            if (grid[x][y] == 0 || visited[x][y]) {
                                continue
                            }

                            visited[x][y] = true
                            queue = append(queue, [2]int{x, y})
                        }
                    }
                }

                if !flag {
                    ans += count
                }
            }
        }
    }

    return ans
}

func isValid(n int, m int, r int, c int) bool {
    return r >= 0 && r < n && c >= 0 && c < m
}
