class Solution {
    fun alternateDigitSum(n: Int): Int {
        val s: String = n.toString()
        val len: Int = s.length
        
        var ans = 0
        for (i in 0..len-1) {
            if (i % 2 == 0) {
                ans += s.get(i).toString().toInt()
            } else {
                ans -= s.get(i).toString().toInt()
            }
        }
        
        return ans
    }
}
