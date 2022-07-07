func ncr(m, n int) int {
    ans := 1
    for i := 1; i <= n; i++ {
        ans = ans * (m-i+1) / i
    }
    return ans
}

func uniquePaths(m int, n int) int {
    if m > n {
        m, n = n, m
    }
    return ncr(m+n-2, m-1)
}
