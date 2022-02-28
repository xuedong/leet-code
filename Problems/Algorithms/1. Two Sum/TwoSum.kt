class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var map: HashMap<Int, Int> = HashMap<Int, Int>()
        
        val len: Int = nums.size
        for (i in 0..len-1) {
            val rest: Int = target - nums[i];
            if (map.containsKey(rest)) {
                return intArrayOf(map.get(rest)!!, i)
            }

            map.put(nums[i], i)
        }
        
        return intArrayOf(-1, -1)
    }
}

