func findJudge(n int, trust [][]int) int {
    scores := make([]int, n+1)

    for _, pair := range trust {
        scores[pair[0]] -= 1
        scores[pair[1]] += 1
    }

    i := 1
    for i < n+1 {
        if scores[i] == n-1 {
            break
        }
        i++
    }

    if i <= n {
        return i
    }
    return -1
}
