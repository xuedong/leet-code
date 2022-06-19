class Solution {
    fun minimumNumbers(num: Int, k: Int): Int {
        if (num == 0) return 0
        
        for (i in 1..10) {
            if ((i * k) % 10 == num % 10 && i * k <= num) {
                return i
            }
        }
        return -1
    }
}

