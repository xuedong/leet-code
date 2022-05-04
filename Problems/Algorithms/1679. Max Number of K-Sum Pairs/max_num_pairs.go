func maxOperations(nums []int, k int) int {
    var pairs = make(map[int]int)

    ans := 0
    for _, num := range nums {
        if _, ok := pairs[k-num]; ok && pairs[k-num] > 0 {
            pairs[k-num]--
            ans++
        } else {
            pairs[num]++
        }
    }

    return ans
}
