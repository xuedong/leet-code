class Solution {
    fun canReach(arr: IntArray, start: Int): Boolean {
        if (start >= 0 && start < arr.size && arr[start] >= 0) {
            arr[start] *= -1
            
            if (arr[start] == 0) {
                return true
            } else {
                return canReach(arr, start+arr[start]) || canReach(arr, start-arr[start])
            }
        }
        
        return false
    }
}

