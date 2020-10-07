class Solution {
    fun thirdMax(nums: IntArray): Int {
        val length = nums.size
           
        var first = 0
        var second = 0
        var third = 0
        
        for (i in 0..(length-1)) {
            if (nums[i] > nums[first]) {
                var temp = first
                first = i
                third = second
                second = temp
            }
            else if (nums[i] == nums[first]) {
                if (second == first) {
                    second = i
                    third = i
                }
                first = i
            } else if (nums[i] < nums[first] && second == first) {
                second = i
                third = i
            } else if (nums[i] < nums[first] && nums[i] > nums[second]) {
                var temp = second
                second = i
                third = temp
            } else if (nums[i] < nums[first] && nums[i] == nums[second]) {
                if (third == second) {
                    third = i
                }
                second = i
            } else if (nums[i] < nums[second] && third == second) {
                third = i
            } else if (nums[i] < nums[second] && nums[i] >= nums[third]) {
                third = i
            }
        }
        
        if (third == second) return nums[first]
        return nums[third]
    }
}

