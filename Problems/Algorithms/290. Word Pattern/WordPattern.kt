class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val arr = s.split(" ")
        if (arr.size != pattern.length) {
            return false
        }
        
        val bijection = mutableMapOf<Char, String>()
        for (i in 0..pattern.length-1) {
            val ch = pattern.get(i)
            if (!bijection.containsKey(ch)) {
                if (bijection.containsValue(arr[i])) {
                    return false
                }
                bijection.put(ch, arr[i])
            } else {
                if (arr[i] != bijection[ch]) {
                    return false
                }
            }
        }
        
        return true
    }
}

