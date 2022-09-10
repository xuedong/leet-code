class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        if (numRows == 0) return listOf()
        if (numRows == 1) return listOf(listOf(1))
        if (numRows == 2) return listOf(listOf(1), listOf(1, 1))
        
        val ans = ArrayList<List<Int>>()
        ans.add(listOf(1))
        ans.add(listOf(1, 1))
        for (i in 3..numRows) {
            val list = ArrayList<Int>()
            list.add(1)
            val prev = ans.last()
            for (j in 0..prev.size-2) {
                list.add(prev.get(j) + prev.get(j+1))
            }
            list.add(1)
            ans.add(list)
        }
        
        return ans
    }
}

