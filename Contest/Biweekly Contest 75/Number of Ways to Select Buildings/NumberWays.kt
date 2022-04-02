class Solution {
    fun numberOfWays(s: String): Long {
        var count = 0.toLong()
        val n = s.length
        
        var totalZeros = 0.toLong() 
        for (i in 0..n-1) {
            if (s[i] == '0') {
                totalZeros++
            }
        }
        
        var totalOnes = n.toLong() - totalZeros
        
        var currZeros = 0.toLong()
        var currOnes = 0.toLong()
        if (s[0] == '1') {
            currOnes++
        } else {
            currZeros++
        }
        
        for (i in 1..n-1) {
            if (s[i] == '0') {
                count += currOnes * (totalOnes - currOnes)
                currZeros++
            } else {
                count += currZeros * (totalZeros - currZeros)
                currOnes++
            }
        }
        
        return count
    }
}

