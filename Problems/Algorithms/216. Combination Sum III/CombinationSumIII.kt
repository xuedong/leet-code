class Solution {
    private val curr: MutableList<Int>
    private val res: MutableList<MutableList<Int>>
    
    init {
        curr = mutableListOf()
        res = mutableListOf()
    }
    
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        aux(k, n, 1)
        return res
    }
    
    private fun aux(k: Int, n: Int, start: Int): Unit {
        if (curr.size == k && n == 0) {
            res.add(ArrayList(curr))
            return
        }
        
        for (i in start..minOf(9, n)) {
            curr.add(i)
            aux(k, n-i, i+1)
            curr.removeAt(curr.size - 1)
        }
    }
}

