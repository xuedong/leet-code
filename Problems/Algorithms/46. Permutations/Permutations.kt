class Solution {    
    val curr: MutableList<Int>
    val res: MutableList<MutableList<Int>>
    
    init {
        curr = mutableListOf()
        res = mutableListOf()
    }
    
    fun permute(nums: IntArray): List<List<Int>> {
        val used = BooleanArray(nums.size) { false }
        aux(nums, used)
        return res
    }
    
    private fun aux(nums: IntArray, used: BooleanArray): Unit {
        if (nums.size == curr.size) {
            res.add(ArrayList(curr))
            return
        }
        
        for (i in 0..nums.size-1) {
            if (used[i]) continue
            
            used[i] = true
            curr.add(nums[i])
            aux(nums, used)
            used[i] = false
            curr.removeAt(curr.size-1)
        }
    }
}

