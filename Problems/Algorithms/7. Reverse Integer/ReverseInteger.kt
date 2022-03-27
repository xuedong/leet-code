class Solution {
    fun reverse(x: Int): Int {
        val str = Math.abs(x).toString().reversed()
        val ans = str.toIntOrNull() ?: 0
        if (x < 0) return -ans
        else return ans
    }
}

