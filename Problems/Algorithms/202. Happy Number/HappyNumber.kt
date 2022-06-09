class Solution {
    fun isHappy(n: Int): Boolean {
        var slow = n
        var fast = process(n)
        
        while (fast != 1 && slow != fast) {
            slow = process(slow)
            fast = process(process(fast))
        }
        
        return fast == 1
    }
    
    private fun process(n: Int): Int {
        var ans = 0
        var curr = n
        while (curr != 0) {
            val rest = curr % 10
            ans += rest * rest
            curr /= 10
        }
        
        return ans
    }
}

