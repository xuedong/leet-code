func nearestExit(maze [][]byte, entrance []int) int {
    n, m := len(maze), len(maze[0])

    neighbors := [4][2]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}
    visited := make([][]bool, n)
    for row := range visited {
        visited[row] = make([]bool, m)
    }

    queue := make([][3]int, 0)
    sx, sy := entrance[0], entrance[1]
    queue = append(queue, [3]int{sx, sy, 0})
    visited[sx][sy] = true

    for len(queue) > 0 {
        r, c, d := queue[0][0], queue[0][1], queue[0][2]
        queue = queue[1:]

        if d != 0 && (r == 0 || r == n-1 || c == 0 || c == m-1) {
            return d
        }

        for _, neighbor := range neighbors {
            x, y := r + neighbor[0], c + neighbor[1]
            if x >= 0 && y >= 0 && x < n && y < m && !visited[x][y] && maze[x][y] == '.' {
                visited[x][y] = true
                queue = append(queue, [3]int{x, y, d+1})
            }
        }
    }

    return -1
}
