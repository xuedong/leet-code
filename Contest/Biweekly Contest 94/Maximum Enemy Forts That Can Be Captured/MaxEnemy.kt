class Solution {
    fun captureForts(forts: IntArray): Int {
        val n = forts.size
        
        var ans = 0
        var i = 0
        while (i < n) {
            var curr = 0
            if (forts[i] == 1) {
                i++
                var j = i
                while (j < n && forts[j] == 0) {
                    curr++
                    j++
                }
                
                if (j == n || forts[j] == 1) {
                    curr = 0
                }
            } else if (forts[i] == -1) {
                i++
                var j = i
                while (j < n && forts[j] == 0) {
                    curr++
                    j++
                }
                
                if (j == n || forts[j] == -1) {
                    curr = 0
                }
            } else {
                i++
                continue
            }
            
            ans = maxOf(ans, curr)
        }
        
        return ans
    }
}
