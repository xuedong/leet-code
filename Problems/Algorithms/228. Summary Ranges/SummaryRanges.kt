class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val ans = mutableListOf<String>()
        if (nums.isEmpty()) {
            return ans
        }
        
        var start: Int = 0
        var end: Int = 0
        
        val len: Int = nums.size
        for (idx in 0..len-1) {
            val curr = nums[idx]
            val prev = nums[end]
            if (curr.toLong() - prev.toLong() > 1.toLong()) {
                if (start == end) {
                    ans.add(String.format("%d", nums[start]))
                } else {
                    ans.add(String.format("%d->%d", nums[start], nums[end]))
                }
                
                start = idx
                end = idx
            } else if (curr.toLong() - prev.toLong() == 1.toLong()) {
                end++
            }
        }
        
        if (start == end) {
            ans.add(String.format("%d", nums[start]))
        } else {
            ans.add(String.format("%d->%d", nums[start], nums[end]))
        }
        
        return ans
    }
}

