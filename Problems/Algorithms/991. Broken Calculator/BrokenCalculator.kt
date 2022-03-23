class Solution {
    fun brokenCalc(startValue: Int, target: Int): Int {
        if (startValue >= target) return startValue - target
        
        if (target % 2 == 0) return 1 + brokenCalc(startValue, target/2)
        
        return 1 + brokenCalc(startValue, target+1)
    }
}

