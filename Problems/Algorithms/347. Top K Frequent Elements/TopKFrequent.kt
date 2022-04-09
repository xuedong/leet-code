class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        if (k >= nums.size) return nums
        
        val map = mutableMapOf<Int, Int>()
        for (num in nums) {
            map.put(num, map.getOrDefault(num, 0) + 1)
        }
        
        val heap = PriorityQueue<Int>({ a, b -> map.get(a)!! - map.get(b)!! })
        for (num in map.keys) {
            heap.add(num)
            if (heap.size > k) heap.poll()
        }
        
        val result = IntArray(k)
        for (i in 0..k-1) {
            result[i] = heap.poll()
        }
        return result
    }
}

