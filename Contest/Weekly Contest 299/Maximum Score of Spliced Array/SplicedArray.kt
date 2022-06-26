class Solution {
    fun maximumsSplicedArray(nums1: IntArray, nums2: IntArray): Int {
        val n = nums1.size
        if (n == 1) return maxOf(nums1[0], nums2[0])

        val prefixes1 = IntArray(n) { 0 }
        var prefix1 = 0
        for (i in 0..n-1) {
            prefix1 += nums1[i]
            prefixes1[i] = prefix1
        }

        val prefixes2 = IntArray(n) { 0 }
        var prefix2 = 0
        for (i in 0..n-1) {
            prefix2 += nums2[i]
            prefixes2[i] = prefix2
        }

        var ans1 = 0
        var curr1 = 0
        var j = -1
        for (i in 0..n-1) {
            if (curr1 + nums1[i] - nums2[i] > 0) {
                j = i
                curr1 = 0
            } else {
                if (j == -1) {
                    ans1 = prefixes2[i] + prefixes1[n-1] - prefixes1[i]
                } else {
                    ans1 = maxOf(ans1, prefixes2[i] - prefixes2[j] + prefixes1[n-1] - (prefixes1[i] - prefixes1[j]))
                }
                curr1 += nums1[i] - nums2[i]
            }
        }

        var ans2 = 0
        var curr2 = 0
        j = -1
        for (i in 0..n-1) {
            if (curr2 + nums2[i] - nums1[i] > 0) {
                j = i
                curr2 = 0
            } else {
                if (j == -1) {
                    ans2 = prefixes1[i] + prefixes2[n-1] - prefixes2[i]
                } else {
                    ans2 = maxOf(ans2, prefixes1[i] - prefixes1[j] + prefixes2[n-1] - (prefixes2[i] - prefixes2[j]))
                }
                curr2 += nums2[i] - nums1[i]
            }
        }

        return maxOf(ans1, ans2)
    }
}
