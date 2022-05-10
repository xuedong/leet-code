class Solution {
    private val curr: MutableList<Int>
    private val res: MutableList<MutableList<Int>>
    
    init {
        curr = mutableListOf()
        res = mutableListOf()
    }
    
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        aux(candidates, target, 0)
        return res
    }
    
    private fun aux(candidates: IntArray, target: Int, start: Int): Unit {
        if (target == 0) {
            res.add(ArrayList(curr))
            return
        }
        
        if (target > 0) {
            for (i in start..candidates.size-1) {
                curr.add(candidates[i])
                aux(candidates, target-candidates[i], i)
                curr.removeAt(curr.size - 1)
            }
        }
    }
}

