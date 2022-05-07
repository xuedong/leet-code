/* The following solution using ArrayDeque will invoke
 * time limit error for the last test.
 * A workaround is to use Stack from Java...
 */
class Solution {
    fun find132pattern(nums: IntArray): Boolean {
        val stack = ArrayDeque<Int>()
        var third = Int.MIN_VALUE
        
        for (i in nums.size-1 downTo 0) {
            if (nums[i] < third) return true
            
            while (!stack.isEmpty() && stack.last() < nums[i]) {
                third = stack.removeLast()
            }
            stack.add(nums[i])
        }
        
        return false
    }
}

