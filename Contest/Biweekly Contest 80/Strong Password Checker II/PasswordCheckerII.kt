class Solution {
    fun strongPasswordCheckerII(password: String): Boolean {
        val n = password.length
        if (n < 8) return false
        
        val chars = "!@#$%^&*()-+"
        
        var containsLower = false
        var containsUpper = false
        var containsDigit = false
        var containsSpecial = false
        for (i in 0..n-1) {
            val char = password.get(i)
            if (i >= 1 && char == password.get(i-1)) {
                return false
            }
            
            if (char.isLowerCase()) {
                containsLower = true
            }
            if (char.isUpperCase()) {
                containsUpper = true
            }
            if (char.isDigit()) {
                containsDigit = true
            }
            if (chars.contains(char)) {
                containsSpecial = true
            }
        }
        
        return containsLower && containsUpper && containsDigit && containsSpecial
    }
}

