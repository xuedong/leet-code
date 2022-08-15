class Solution {
    fun nthSuperUglyNumber(n: Int, primes: IntArray): Int {
        val ugly = LongArray(n)
        ugly[0] = 1
        
        val m = primes.size
        val indices = IntArray(m) { 0 }
        val factors = LongArray(m) { 0 }
        for (i in 0..m-1) {
            factors[i] = primes[i].toLong()
        }
        
        for (i in 1..n-1) {
            val min = arrayMin(factors)
            ugly[i] = min
            
            for (j in 0..m-1) {
                if (factors[j] == min) {
                    factors[j] = primes[j].toLong() * ugly[++indices[j]]
                }
            }
        }
        return ugly[n-1].toInt()
    }
    
    private fun arrayMin(nums: LongArray): Long {
        val n = nums.size
        
        var min = nums[0]
        for (i in 0..n-1) {
            min = minOf(min, nums[i])
        }
        
        return min
    }
}

