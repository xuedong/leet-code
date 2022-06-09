class Solution {
    fun trap(height: IntArray): Int {
        val stack = ArrayDeque<Int>()
        var ans = 0
        var id = 0
        while (id < height.size) {
            while (!stack.isEmpty() && height[id] > height[stack.last()]) {
                val curr = stack.removeLast()
                if (stack.isEmpty()) break
                
                ans += (minOf(height[id], height[stack.last()]) - height[curr]) * (id - stack.last() - 1)
            }
            
            stack.add(id)
            id++
        }
        
        return ans
    }
}

