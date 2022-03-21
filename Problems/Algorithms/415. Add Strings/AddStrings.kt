class Solution {
    fun addStrings(num1: String, num2: String): String {
        val l1 = num1.length
        val l2 = num2.length
        val max = maxOf(l1, l2)
        
        val s1 = num1.padStart(max, '0')
        val s2 = num2.padStart(max, '0')
        
        var carry = 0
        var result = StringBuilder()
        for (i in max-1 downTo 0) {
            val current = (s1[i] - '0') + (s2[i] - '0') + carry
            result.append(current % 10)
            carry = current / 10
        }
        
        if (carry > 0) {
            result.append(1)
        }
        
        return result.reversed().toString()
    }
}

