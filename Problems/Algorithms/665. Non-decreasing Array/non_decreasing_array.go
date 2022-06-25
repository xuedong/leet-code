func checkPossibility(nums []int) bool {
    n := len(nums)
    if n <= 2 {
        return true
    }

    count := 0
    if nums[0] > nums[1] {
        nums[0] = nums[1]
        count++
    }
    for i := 2; i < n; i++ {
        if nums[i-1] > nums[i] {
            count++
            if nums[i-2] > nums[i] {
                nums[i] = nums[i-1]
            } else {
                nums[i-1] = nums[i]
            }
        }

        if count >= 2 {
            return false
        }
    }

    return true
}
