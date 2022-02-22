class Solution {
    fun titleToNumber(columnTitle: String): Int {
        val len: Int = columnTitle.length
        
        var ans: Int = 0
        for (i in len-1 downTo 0) {
            val ch = columnTitle[i]
            val num = ch.toByte().toInt() - 64
            ans += (Math.pow(26.toDouble(), (len-1-i).toDouble())).toInt() * num
        }
        
        return ans
    }
}

