class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val result = IntArray(2)
        
        var left = 0
        var right = numbers.size - 1
        
        while (left < right) {
            val sum = numbers[left] + numbers[right]
            
            if (sum == target) {
                result[0] = left + 1
                result[1] = right + 1
                return result
            } else if (sum < target) {
                left++
            } else {
                right--
            }
        }
        
        return result
    }
}

