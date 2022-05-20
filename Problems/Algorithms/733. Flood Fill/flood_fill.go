func floodFill(image [][]int, sr int, sc int, newColor int) [][]int {
    n, m := len(image), len(image[0])
    neighbors := [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}

    color := image[sr][sc]
    if color != newColor {
        dfs(image, neighbors, n, m, sr, sc, color, newColor)
    }

    return image
}

func isValid(n int, m int, r int, c int) bool {
    return r >= 0 && r < n && c >= 0 && c < m
}

func dfs(image [][]int, neighbors [][]int, n int, m int, r int, c int, color int, newColor int) {
    if image[r][c] == color {
        image[r][c] = newColor

        for _, neighbor := range neighbors {
            x, y := r + neighbor[0], c + neighbor[1]
            if isValid(n, m, x, y) {
                dfs(image, neighbors, n, m, x, y, color, newColor)
            }
        }
    }
}
