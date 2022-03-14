class Solution {
    fun majorityElement(nums: IntArray): Int {
        var majority = -1
        
        var count = 0
        for (num in nums) {
            if (count == 0) {
                majority = num
                count = 1
            } else if (majority == num) {
                count++
            } else {
                count--
            }
        }
        
        return majority
    }
}

