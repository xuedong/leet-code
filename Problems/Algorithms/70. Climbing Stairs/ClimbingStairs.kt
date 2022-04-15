class Solution {
    fun climbStairs(n: Int): Int {
        val steps = IntArray(n+1)
        steps[0] = 1
        steps[1] = 1
        
        for (i in 2..n) {
            steps[i] = steps[i-1] + steps[i-2]
        }
        
        return steps[n]
    }
}

