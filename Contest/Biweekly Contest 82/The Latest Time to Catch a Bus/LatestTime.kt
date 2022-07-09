class Solution {
    fun latestTimeCatchTheBus(buses: IntArray, passengers: IntArray, capacity: Int): Int {
        buses.sort()
        passengers.sort()
        
        val nb = buses.size
        val np = passengers.size
        
        var i = 0
        var j = 0
        var ans = 1
        while (i < nb && j < np) {
            if (j == 0) {
                ans = passengers[0] - 1
            } else if (passengers[j] - 1 != passengers[j-1]) {
                ans = passengers[j] - 1
            }
            
            var curr = 0
            while (j < np && curr < capacity && buses[i] >= passengers[j]) {
                if (j > 0 && passengers[j] - 1 != passengers[j-1]) {
                    ans = passengers[j] - 1
                }
                j++
                curr++
            }
            
            if (curr < capacity && ((j > 0 && passengers[j-1] != buses[i]) || (j == 0))) {
                ans = buses[i]
            }
            
            i++
        }
        
        while (i < nb) {
            ans = buses[i]
            i++
        }
        
        return ans
    }
}

