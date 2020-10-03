class Solution1 {
    fun findNumbers(nums: IntArray): Int {
        var evens = 0
        
        for (element in nums) {
            var digits = 0
            var current = element
            while (current  > 0) {
                digits += 1
                current /= 10
            }
            if (digits % 2 == 0) {
                evens += 1
            }
        }
        
        return evens
    }
}


class Solution2 {
    fun findNumbers(nums: IntArray): Int {
        return nums.map { it.toString() }.filter { it.length % 2 == 0 }.count()
    }
}

