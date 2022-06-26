func countHousePlacements(n int) int {
    num := fibonacci(n)
    return (num * num) % 1000000007
}

func fibonacci(n int) int {
    f := make([]int, n+1, n+2)
    if n < 2 {
        f = f[0:2]
    }
    f[0] = 1
    f[1] = 2
    for i := 2; i <= n; i++ {
        f[i] = (f[i-1] + f[i-2]) % 1000000007
    }
    return f[n]
}
