class Solution {
    fun sumOfNumberAndReverse(num: Int): Boolean {
        if (num <= 18) {
            return false || num % 2 == 0 || num % 11 == 0
        }
        
        if (num <= 198) {
            for (i in 0..9) {
                val rest = num - 20 * i
                if (rest > 0 && rest % 101 == 0) {
                    return true
                }
            }
            return false || num % 11 == 0
        }

        if (num <= 1998) {
            for (i in 0..18) {
                val rest = num - 110 * i
                if (rest > 0 && rest % 1001 == 0) {
                    return true
                }
            }
            for (i in 0..9) {
                val rest = num - 20 * i
                if (rest > 0 && rest % 101 == 0) {
                    return true
                }
            }
            return false
        }

        if (num <= 19998) {
            for (i in 0..9) {
                for (j in 0..18) {
                    val rest = num - 1010 * j - 200 * i
                    if (rest > 0 && rest % 10001 == 0) {
                        return true
                    }
                }
            }
            for (i in 0..18) {
                val rest = num - 110 * i
                if (rest > 0 && rest % 1001 == 0) {
                    return true
                }
            }
            return false
        }

        for (i in 0..18){
            for (j in 0..18) {
                val rest = num - 100100 * i - 100010 * j
                if (rest > 0 && rest % 100001 == 0) {
                    return true
                }
            }
        }
        for (i in 0..9) {
            for (j in 0..18) {
                val rest = num - 1010 * j - 200 * i
                if (rest > 0 && rest % 10001 == 0) {
                    return true
                }
            }
        }
        return false
    }
}
