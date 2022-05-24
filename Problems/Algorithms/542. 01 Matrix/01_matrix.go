func updateMatrix(mat [][]int) [][]int {
    n, m := len(mat), len(mat[0])
    results := make([][]int, n)
    for row := range results {
        results[row] = make([]int, m)
    }

    queue := make([][2]int, 0)
    for i := 0; i < n; i++ {
        for j:= 0; j < m; j++ {
            if mat[i][j] == 0 {
                queue = append(queue, [2]int{i, j})
            } else {
                results[i][j] = n * m
            }
        }
    }

    neighbors := [4][2]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}
    for len(queue) > 0 {
        r, c := queue[0][0], queue[0][1]
        queue = queue[1:]

        for _, neighbor := range neighbors {
            x, y := r + neighbor[0], c + neighbor[1]
            if isValid(n, m, x, y) {
                if results[x][y] > results[r][c] + 1 {
                    results[x][y] = results[r][c] + 1
                    queue = append(queue, [2]int{x, y})
                }
            }
        }
    }

    return results
}

func isValid(n int, m int, r int, c int) bool {
    return r >= 0 && c >= 0 && r < n && c < m
}
