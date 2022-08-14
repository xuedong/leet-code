class Solution {
    fun smallestNumber(pattern: String): String {
        var result: String = ""
        
        val n = pattern.length
        val unvisited: MutableList<String> = mutableListOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
        
        var i = 0
        while (i < n) {
            var count = 0
            while (i < n && pattern.get(i) == 'D') {
                i++
                count++
            }
            
            for (j in count downTo 0) {
                result += unvisited[j]
            }
            for (k in 0..count) {
                unvisited.removeAt(0)
            }
            
            i++
        }
        if (pattern[n-1] == 'I') {
            result += unvisited[0]
        }
        
        return result
    }
}

