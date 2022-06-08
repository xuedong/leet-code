class Solution {
    fun isPalindrome(s: String): Boolean {
        val re = Regex("[^A-Za-z0-9]")
        var string: String = re.replace(s, "")
        
        val n = string.length
        if (n <= 1) return true
        
        for (i in 0..n/2) {
            if (string[i].toLowerCase() != string[n-1-i].toLowerCase()) return false
        }
        
        return true
    }
}

