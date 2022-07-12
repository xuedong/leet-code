package main

import (
    "sort"
)

func dfs(nums []int, sums []int, length int, index int) bool {
    if index == len(nums) {
        return sums[0] == sums[1] && sums[0] == sums[2] && sums[0] == sums[3]
    }

    curr := nums[index]
    if curr > length {
        return false
    }

    for i := range sums {
        if curr + sums[i] <= length {
            sums[i] += curr
            if dfs(nums, sums, length, index+1) {
                return true
            }
            sums[i] -= curr
        }
    }

    return false
}

func makesquare(matchsticks []int) bool {
    if matchsticks == nil || len(matchsticks) == 0 {
        return false
    }

    sort.Sort(sort.Reverse(sort.IntSlice(matchsticks)))

    perimeter := 0
    for i := range matchsticks {
        perimeter += matchsticks[i]
    }
    if perimeter % 4 != 0 {
        return false
    }
    length := perimeter / 4

    sums := make([]int, 4)

    return dfs(matchsticks, sums, length, 0)
}
