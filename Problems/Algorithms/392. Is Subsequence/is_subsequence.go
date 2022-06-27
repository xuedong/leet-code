func isSubsequence(s string, t string) bool {
    ls, lt := len(s), len(t)
    if ls > lt {
        return false
    }

    i, j := 0, 0
    for i < ls && j < lt {
        if s[i] == t[j] {
            i++
        }
        j++
    }

    return i == ls
}
