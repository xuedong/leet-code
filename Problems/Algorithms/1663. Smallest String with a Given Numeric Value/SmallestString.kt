class Solution {
    fun getSmallestString(n: Int, k: Int): String {
        val sb = StringBuilder()
        
        var len = n
        var rest = k
        while (len > 0) {
            val curr = rest - len + 1
			
            if (curr >= 26) {
                sb.append('z')
                rest -= 26
            } else {
                sb.append('a'+curr-1)
                rest -= curr
            }
            
            len--;
        }
        
        return sb.reversed().toString()
    }
}

