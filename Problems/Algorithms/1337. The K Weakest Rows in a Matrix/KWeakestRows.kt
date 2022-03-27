class Solution {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        val result = mutableListOf<Int>()
    
        for (i in mat.indices) {
            val count = mat[i].count { it == 1 }
            map[i] = count
        }
        
        map.toList().sortedBy { (_, value) -> value }.forEach { result.add(it.first) } 
        return result.take(k).toIntArray()
    }
}

