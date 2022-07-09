class Solution {
    fun validSubarraySize(nums: IntArray, threshold: Int): Int {
        val n = nums.size
        
        val stack = Stack<Int>()
        val nextSmaller = IntArray(n) { n }
        val prevSmaller = IntArray(n) { -1 }

        for (i in 0..n-1) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                nextSmaller[stack.peek()] = i
                stack.pop()
            }
            stack.push(i)
        }

        while (!stack.isEmpty()) {
            stack.pop()
        }
        
        for (i in n-1 downTo 0) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                prevSmaller[stack.peek()] = i
                stack.pop()
            }
            stack.push(i)
        }
        
        for (i in 0..n-1) {
            val right = nextSmaller[i]
            val left = prevSmaller[i]
            
            val len = right - left - 1
            if (nums[i] > threshold.toDouble() / len.toDouble()) {
                return len
            }
        }
        
        return -1
    }
}

