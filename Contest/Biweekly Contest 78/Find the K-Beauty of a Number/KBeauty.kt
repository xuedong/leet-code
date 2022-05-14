class Solution {
    fun divisorSubstrings(num: Int, k: Int): Int {
        val str = num.toString()
        
        var ans = 0
        for (i in 0..str.length-k) {
            val cur = str.substring(i, i+k).toInt()
            if (cur == 0) continue
            if (num % cur == 0) ans++
        }
        
        return ans
    }
}

