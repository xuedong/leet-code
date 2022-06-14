class Solution {
    fun freqAlphabets(s: String): String {
        val sb = StringBuilder()
        
        var i = s.length - 1
        while (i >= 0) {
            if (s.get(i) == '#') {
                sb.append((s.substring(i-2, i).toInt() + 96).toChar())
                i -= 3
            } else {
                sb.append((s.get(i) - '1' + 97).toChar())
                i--
            }
        }
        
        return sb.reversed().toString()
    }
}

