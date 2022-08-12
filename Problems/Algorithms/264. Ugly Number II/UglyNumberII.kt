class Solution {
    fun nthUglyNumber(n: Int): Int {
        val ugly = IntArray(n)
        ugly[0] = 1
        
        var idx2 = 0; var idx3 = 0; var idx5 = 0
        var fact2 = 2; var fact3 = 3; var fact5 = 5
        for (i in 1..n-1) {
            val min = minOf(minOf(fact2, fact3), fact5)
            ugly[i] = min
            
            if (fact2 == min) {
                fact2 = 2 * ugly[++idx2]
            }
            if (fact3 == min) {
                fact3 = 3 * ugly[++idx3]
            }
            if (fact5 == min) {
                fact5 = 5 * ugly[++idx5]
            }
        }
        return ugly[n-1]
    }
}

