class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var area = 0
        
        while (left < right) {
            val curr = (right - left) * minOf(height[left], height[right])
            area = maxOf(area, curr)
            
            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }
        
        return area
    }
}

