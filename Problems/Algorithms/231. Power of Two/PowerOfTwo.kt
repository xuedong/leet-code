class Solution {
    fun isPowerOfTwo(n: Int): Boolean {
        return ((n and n-1) == 0 && n > 0)
    }
}

