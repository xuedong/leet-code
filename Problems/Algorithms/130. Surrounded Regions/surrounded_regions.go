func solve(board [][]byte)  {
    n, m := len(board), len(board[0])

    neighbors := [4][2]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}

    queue := make([][2]int, 0)
    for i := 0; i < n; i++ {
        if board[i][0] == 'O' {
            queue = append(queue, [2]int{i, 0})
        }
        if board[i][m-1] == 'O' {
            queue = append(queue, [2]int{i, m-1})
        }
    }
    for j := 0; j < m; j++ {
        if board[0][j] == 'O' {
            queue = append(queue, [2]int{0, j})
        }
        if board[n-1][j] == 'O' {
            queue = append(queue, [2]int{n-1, j})
        }
    }

    for len(queue) > 0 {
        curr := queue[0]
        queue = queue[1:]
        r, c := curr[0], curr[1]
        board[r][c] = 'B'

        for _, neighbor := range neighbors {
            x, y := r + neighbor[0], c + neighbor[1]
            if !isValid(n, m, x, y) {
                continue
            }

            if (board[x][y] == 'X' || board[x][y] == 'B') {
                continue
            }

            queue = append(queue, [2]int{x, y})
        }
    }

    for i := 0; i < n; i++ {
        for j := 0; j < m; j++ {
            if board[i][j] == 'O' {
                board[i][j] = 'X'
            } else if board[i][j] == 'B' {
                board[i][j] = 'O'
            }
        }
    }
}

func isValid(n int, m int, r int, c int) bool {
    return r >= 0 && r < n && c >= 0 && c < m
}
