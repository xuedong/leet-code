class Solution {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        var left = 0
        var right = arr.size - 1
        
        while (left < right) {
            var mid = left + (right - left) / 2
            
            if (arr[mid] < arr[mid+1]) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        
        return left
    }
}

