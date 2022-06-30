func canMakePaliQueries(s string, queries [][]int) []bool {
    n := len(queries)
    ans := make([]bool, n)

    prefix := make([][]int, 26)
    for row := range prefix {
        prefix[row] = make([]int, len(s)+1)

        for i := 1; i <= len(s); i++ {
            if s[i-1] == string('a'+row)[0] {
                prefix[row][i] = prefix[row][i-1] + 1
            } else {
                prefix[row][i] = prefix[row][i-1]
            }
        }
    }

    for i := 0; i < n; i++ {
        l, r := queries[i][0], queries[i][1]

        odds := 0
        for i := 0; i < 26; i++ {
            if (prefix[i][r+1] - prefix[i][l]) % 2 == 1 {
                odds += 1
            }
        }

        if odds / 2 <= queries[i][2] {
            ans[i] = true
        }
    }

    return ans
}
