func shortestPathBinaryMatrix(grid [][]int) int {
    n, m := len(grid), len(grid[0])

    if grid[0][0] == 1 || grid[n-1][m-1] == 1 {
        return -1
    }

    visited := make([][]bool, n)
    for row := range visited {
        visited[row] = make([]bool, m)
    }

    neighbors := [8][2]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}}

    queue := make([][3]int, 0)
    queue = append(queue, [3]int{0, 0, 1})
    visited[0][0] = true

    for len(queue) > 0 {
        r, c, length := queue[0][0], queue[0][1], queue[0][2]
        queue = queue[1:]

        if r == n-1 && c == m-1 {
            return length
        }

        for _, neighbor := range neighbors {
            x, y := r + neighbor[0], c + neighbor[1]
            if isValid(n, m, x, y) && !visited[x][y] && grid[x][y] == 0 {
                queue = append(queue, [3]int{x, y, length+1})
                visited[x][y] = true
            }
        }
    }

    return -1
}

func isValid(n int, m int, r int, c int) bool {
    return r >= 0 && c >= 0 && r < n && c < m
}
