// The following solution leads to TLE
class Solution {
    private val curr: MutableList<Int>
    private var res: Int
    
    init {
        curr = mutableListOf()
        res = 0
    }
    
    fun combinationSum4(nums: IntArray, target: Int): Int {
        aux(nums, target, 0)
        return res
    }
    
    private fun aux(nums: IntArray, target: Int, start: Int): Unit {
        if (target == 0) {
            res++
            return
        }
        
        if (target > 0) {
            for (i in start..nums.size-1) {
                curr.add(nums[i])
                aux(nums, target-nums[i], start)
                curr.removeAt(curr.size - 1)
            }
        }
    }
}

