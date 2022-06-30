import (
    "sort"
)

func minMoves2(nums []int) int {
    n := len(nums)

    sort.Ints(nums)

    var median int
    median = nums[n/2]

    ans := 0
    for _, num := range nums {
        if num >= median {
            ans += num - median
        } else {
            ans += median - num
        }
    }
    return ans
}
