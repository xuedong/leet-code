class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val length = nums.size
        val resList = mutableListOf<Int>()
        if (length == 0) return resList
        var pointer = nums[0]
        
        for (i in nums.indices) {
            if (nums[i] == 0) continue
            pointer = nums[i]
            while (nums[pointer-1] != 0) {
                var temp = pointer
                pointer = nums[temp-1]
                nums[temp-1] = 0
            }
        }
        
        for (i in nums.indices) {
            if (nums[i] != 0) {
                resList.add(i+1)
            }
        }
        return resList
    }
}

