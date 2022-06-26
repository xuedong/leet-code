func maxScore(cardPoints []int, k int) int {
    n := len(cardPoints)
    total := 0
    for i := 0; i < n; i++ {
        total += cardPoints[i]
    }
    if k == n {
        return total
    }

    curr := 0
    for i := 0; i < n-k; i++ {
        curr += cardPoints[i]
    }

    ans := curr
    for i := n-k; i < n; i++ {
        curr += cardPoints[i]
        curr -= cardPoints[i-n+k]
        if curr < ans {
            ans = curr
        }
    }

    return total - ans
}
