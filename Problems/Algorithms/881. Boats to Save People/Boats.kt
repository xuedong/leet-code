class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        
        var ans = 0
        var i = 0
        var j = people.size-1
        while (i < j) {
            if (people[i] + people[j] > limit) {
                j--
                ans++
            } else {
                j--
                i++
                ans++
            }
        }
        
        if (i == j) ans++
        
        return ans
    }
}

