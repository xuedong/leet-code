class Solution {
    fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int {
        arr1.sort()
        arr2.sort()
        
        var ans = arr1.size
        var i = 0
        var j = 0
        while (i < arr1.size && j < arr2.size) {
            if (Math.abs(arr1[i]-arr2[j]) <= d) {
                i++
                ans--
            } else if (arr1[i] < arr2[j]) {
                i++
            } else {
                j++
            }
        }
        
        return ans
    }
}

