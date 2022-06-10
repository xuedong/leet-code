class Solution {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val n = nums.size
        val results = IntArray(n) { -1 }
        
        val stack = ArrayDeque<Int>()
        for (i in 0..2*n-1) {
            while (!stack.isEmpty() && nums[i%n] > nums[stack.last()]) {
                results[stack.last()] = nums[i%n]
                stack.removeLast()
            }
            stack.add(i%n)
        }
        
        return results
    }
}

