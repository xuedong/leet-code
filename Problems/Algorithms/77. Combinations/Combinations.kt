class Solution {
    private val curr: MutableList<Int>
    private val res: MutableList<MutableList<Int>>
    
    init {
        curr = mutableListOf()
        res = mutableListOf()
    }
    
    fun combine(n: Int, k: Int): List<List<Int>> {
        aux(n, k, 1)
        return res
    }
    
    private fun aux(n: Int, k: Int, start: Int): Unit {
        if (curr.size == k) {
            res.add(ArrayList(curr))
            return
        }
        
        for (i in start..n) {
            curr.add(i)
            aux(n, k, i+1)
            curr.removeAt(curr.size - 1)
        }
    }
}

