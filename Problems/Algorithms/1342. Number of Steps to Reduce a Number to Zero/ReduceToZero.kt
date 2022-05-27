class Solution {
    fun numberOfSteps(num: Int): Int {
        if (num == 0) return 0
        
        var curr = num
        
        var ans = 0
        while (curr > 1) {
            if (curr % 2 == 0) {
                ans++
            } else {
                ans += 2
            }
            curr = (curr shr 1)
        }
        
        return ans + 1
    }
}

