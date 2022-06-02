class Solution {
    fun canMeasureWater(jug1Capacity: Int, jug2Capacity: Int, targetCapacity: Int): Boolean {
        if (jug1Capacity + jug2Capacity < targetCapacity) return false
        
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0
    }
    
    private fun gcd(a: Int, b: Int): Int {
        var aa = a
        var bb = b
        
        while (bb != 0) {
            val temp = bb
            bb = aa % bb
            aa = temp
        }
    
        return aa;
    }
}

