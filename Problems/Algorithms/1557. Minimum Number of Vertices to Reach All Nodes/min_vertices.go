func findSmallestSetOfVertices(n int, edges [][]int) []int {
    ins := make([]int, n)

    for _, edge := range edges {
        ins[edge[1]]++
    }

    results := make([]int, 0)
    for id, degree := range ins {
        if degree == 0 {
            results = append(results, id)
        }
    }
    return results
}
