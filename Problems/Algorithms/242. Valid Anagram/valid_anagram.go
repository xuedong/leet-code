package main

import (
    "sort"
    "strings"
)

func sortAnagram(s string) string {
    t := strings.Split(s, "")
    sort.Strings(t)
    return strings.Join(t, "")
}

func isAnagram(s string, t string) bool {
    return sortAnagram(s) == sortAnagram(t)
}
