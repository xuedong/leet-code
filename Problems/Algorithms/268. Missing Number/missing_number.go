func missingNumber(nums []int) int {
    ans := 0

    for _, num := range nums {
        ans = ans ^ num
    }

    for i := 0; i <= len(nums); i++ {
        ans = ans ^ i
    }

    return ans
}
