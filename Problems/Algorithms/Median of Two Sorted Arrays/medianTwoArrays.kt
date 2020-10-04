class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var m = nums1.size
        var n = nums2.size
        val mergedNums = IntArray(m+n)
        var k = 0
        var i = 0
        var j = 0
        
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                mergedNums[k++] = nums1[i]
                i++
            } else {
                mergedNums[k++] = nums2[j]
                j++
            }
        }
        
        while (i < m) {
            mergedNums[k++] = nums1[i]
            i++
        }
        while (j < n) {
            mergedNums[k++] = nums2[j]
            j++
        }
        
        if ((m+n) % 2 == 0) {
            return (mergedNums[(m+n)/2-1] + mergedNums[(m+n)/2]).toDouble() / 2
        } else {
            return mergedNums[(m+n)/2].toDouble()
        }
    }
}

