class Solution {
    fun minSumSquareDiff(nums1: IntArray, nums2: IntArray, k1: Int, k2: Int): Long {
        val n = nums1.size
        
        val differences = IntArray(n)
        for (i in 0..n-1) {
            differences[i] = Math.abs(nums1[i]-nums2[i])
        }
        
        val frequencies: MutableMap<Int, Int> = mutableMapOf()
        for (difference in differences) {
            frequencies.put(difference, frequencies.getOrDefault(difference, 0) + 1)
        }
        
        val pq: PriorityQueue<IntArray> = PriorityQueue { a, b -> b[0] - a[0] }
        for (key in frequencies.keys) {
            pq.offer(intArrayOf(key, frequencies.get(key)!!))
        }
        
        var curr = k1 + k2
        while (!pq.isEmpty()) {
            if (curr == 0) {
                break
            }
            
            val top = pq.poll()
            val key = top[0]
            val count = top[1]
            
            if (key == 0) {
                break
            }

            var prev = 0
            if (!pq.isEmpty()) {
                prev = pq.peek()[0]
            } else {
                pq.offer(intArrayOf(0, 0))
            }
            
            val diff = key - prev
            if (count * diff <= curr) {
                pq.peek()[1] += count
                curr -= count * diff
            } else {
                val equal = curr / count
                val rest = curr - equal * count
                
                val lowerKey = key - equal
                if (lowerKey == 0) {
                    break
                }
                
                pq.offer(intArrayOf(lowerKey, count-rest))
                pq.offer(intArrayOf(lowerKey-1, rest))
                
                curr = 0
            }
        }
        
        var ans: Long = 0
        while (!pq.isEmpty()) {
            val top = pq.poll()
            val key = top[0].toLong()
            val count = top[1].toLong()
            ans += key * key * count
        }
        
        return ans
    }
}

