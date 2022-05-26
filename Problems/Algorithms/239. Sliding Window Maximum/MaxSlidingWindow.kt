class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val queue: MutableList<Int> = mutableListOf()
        val results = IntArray(nums.size-k+1) { 0 }
        
        for (i in 0..k-1) {
            while (!queue.isEmpty()) {
                if (nums[i] > nums[queue.get(queue.size-1)]) {
                    queue.removeAt(queue.size-1)
                } else {
                    break
                }
            }
            queue.add(i)
        }
        
        var j = 0
        for (i in k..nums.size-1) {
            results[j] = nums[queue.get(0)]
            j++
            
            if (queue.get(0) < i-k+1) {
                queue.removeAt(0)
            }
            
            while (!queue.isEmpty()) {
                if (nums[i] > nums[queue.get(queue.size-1)]) {
                    queue.removeAt(queue.size-1)
                } else {
                    break
                }
            }
            
            queue.add(i)
        }
        results[j] = nums[queue.get(0)]
        
        return results
    }
}

