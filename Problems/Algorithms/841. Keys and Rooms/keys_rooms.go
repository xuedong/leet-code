func canVisitAllRooms(rooms [][]int) bool {
    n := len(rooms)

    visited := make([]bool, n)
    dfs(rooms, visited, 0)

    for _, v := range visited {
        if !v {
            return false
        }
    }
    return true
}

func dfs(rooms [][]int, visited []bool, i int) {
    visited[i] = true

    for _, neighbor := range rooms[i] {
        if !visited[neighbor] {
            dfs(rooms, visited, neighbor)
        }
    }
}
