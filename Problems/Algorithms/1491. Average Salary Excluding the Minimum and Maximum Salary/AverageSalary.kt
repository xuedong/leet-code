class Solution {
    fun average(salary: IntArray): Double {
        var sum = 0
        var min = minOf(salary[0], salary[1])
        var max = maxOf(salary[0], salary[1])
        for (i in 2..salary.size-1) {
            val curr = salary[i]
            if (min > curr) {
                sum += min
                min = curr
            } else if (max < curr) {
                sum += max
                max = curr 
            } else {
                sum += curr
            }
        }
        
        return sum / (salary.size-2).toDouble()
    }
}

