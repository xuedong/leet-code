class Solution {
    fun subtractProductAndSum(n: Int): Int {
        var sum = 0
        var prod = 1
        
        var num = n
        while (num != 0) {
            val curr = num % 10
            num /= 10
            
            sum += curr
            prod *= curr
        }
        
        return prod - sum
    }
}

