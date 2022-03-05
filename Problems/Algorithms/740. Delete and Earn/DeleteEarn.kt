class Solution {
    fun deleteAndEarn(nums: IntArray): Int {
        val count: MutableMap<Int, Int> = mutableMapOf<Int, Int>()
	    var min = Int.MAX_VALUE
	    var max = Int.MIN_VALUE
	    for (num in nums) {
		    count.put(num, count.getOrDefault(num, 0)+1)
		    min = minOf(min, num)
		    max = maxOf(max, num)
	    }

	    var prevInclusive = 0
	    var prevExclusive = 0
	    for (i in min..max) {
		    var inclusive = prevExclusive + i * count.getOrDefault(i, 0)
		    var exclusive = maxOf(prevInclusive, prevExclusive)
		    prevInclusive = inclusive
		    prevExclusive = exclusive
	    }
        
	    return maxOf(prevInclusive, prevExclusive)
    }
}

