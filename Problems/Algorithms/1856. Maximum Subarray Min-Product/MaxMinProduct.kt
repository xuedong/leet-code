class Solution {
    fun maxSumMinProduct(nums: IntArray): Int {
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
        
        var prefix: Long = 0
        val prefixes = LongArray(n+1) { 0 }
        for (i in 1..n) {
            prefix += nums[i-1]
            prefixes[i] = prefix
        }
        
        var ans: Long = 0
        for (i in 0..n-1) {
            val right = nextSmaller[i]
            val left = prevSmaller[i]
            
            val sum: Long = prefixes[right] - prefixes[left+1]
            ans = maxOf(ans, sum * nums[i])
        }
        
        return (ans % 1000000007).toInt()
    }
}

