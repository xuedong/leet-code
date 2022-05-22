func countSubIslands(grid1 [][]int, grid2 [][]int) int {
    n, m := len(grid1), len(grid1[0])

    visited := make([][]bool, n)
    for row := range visited {
        visited[row] = make([]bool, m)
    }

    neighbors := [4][2]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}

    ans := 0
    for i := 0; i < n; i++ {
        for j := 0; j < m; j++ {
            if !visited[i][j] && grid1[i][j] == 1 && grid2[i][j] == 1 {
                flag := true
                queue := make([][2]int, 0)
                queue = append(queue, [2]int{i, j})

                for len(queue) > 0 {
                    for k := 0; k < len(queue); k++ {
                        curr := queue[0]
                        queue = queue[1:]
                        r, c := curr[0], curr[1]

                        visited[r][c] = true
                        for _, neighbor := range neighbors {
                            x, y := r + neighbor[0], c + neighbor[1]
                            if !isValid(n, m, x, y) || grid2[x][y] == 0 || visited[x][y] {
                                continue
                            }

                            visited[x][y] = true

                            if grid1[x][y] == 0 {
                                flag = false
                            }
                            queue = append(queue, [2]int{x, y})
                        }
                    }
                }

                if flag {
                    ans++
                }
            }
        }
    }

    return ans
}

func isValid(n int, m int, r int, c int) bool {
    return r >= 0 && r < n && c >= 0 && c < m
}
