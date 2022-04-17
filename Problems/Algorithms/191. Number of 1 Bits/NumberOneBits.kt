class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n: Int): Int {
        var ans = 0
        
        var curr = n
        while (curr != 0) {
            ans++
            curr = (curr and curr-1)
        }
        
        return ans
    }
}

