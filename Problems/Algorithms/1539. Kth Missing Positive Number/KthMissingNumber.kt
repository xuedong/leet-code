class Solution {
    fun findKthPositive(arr: IntArray, k: Int): Int {
        var left = 0
        var right = arr.size
        
        while (left < right) {
            val mid = left + (right - left) / 2
            
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        
        return left + k
    }
}

