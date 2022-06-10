class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val n = nums2.size
        val next: MutableMap<Int, Int> = mutableMapOf()
        
        val stack = ArrayDeque<Int>()
        for (i in 0..n-1) {
            while (!stack.isEmpty() && nums2[i] > stack.last()) {
                next.put(stack.last(), nums2[i])
                stack.removeLast()
            }
            stack.add(nums2[i])
        }
        
        val m = nums1.size
        val results = IntArray(m) { -1 }
        for (i in 0..m-1) {
            if (next.containsKey(nums1[i])) {
                results[i] = next.get(nums1[i])!!
            }
        }
        
        return results
    }
}

