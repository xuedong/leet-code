class Solution {
    fun smallestStringWithSwaps(s: String, pairs: List<List<Int>>): String {
        val numberOfVertices = s.length
        val res = CharArray(numberOfVertices)
        
        val uf = UnionFind(numberOfVertices)
        for (pair in pairs) {
            uf.union(pair.get(0), pair.get(1))
        }
        
        val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        for (i in 0..numberOfVertices-1) {
            val key = uf.find(i)
            val cc: MutableList<Int>
            if (map.containsKey(key)) {
                cc = map.get(key)!!
            } else {
                cc = mutableListOf()
            }
            cc.add(i)
            map.put(key, cc)
        }
        
        for (key in map.keys) {
            val componentIndices = map.get(key)!!
            val componentChars = CharArray(componentIndices.size)
            
            var i = 0
            for (j in componentIndices) {
                componentChars[i] = s.get(j)
                i++
            }
            componentChars.sort()
            
            i = 0
            for (j in componentIndices) {
                res[j] = componentChars[i]
                i++
            }
        }
        
        return res.joinToString("")
    }
    
    class UnionFind(numberOfVertices: Int) {
        val root = IntArray(numberOfVertices)
        val rank = IntArray(numberOfVertices)
        
        init {
            for (i in 0..numberOfVertices-1) {
                root[i] = i
                rank[i] = 1
            }
        }
        
        fun find(x: Int): Int {
            if (x == root[x]) {
                return x
            }
            
            root[x] = find(root[x])
            return root[x]
        }
        
        fun union(x: Int, y: Int): Unit {
            val rootX = find(x)
            val rootY = find(y)
            
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY
                } else {
                    root[rootY] = rootX
                    rank[rootX]++
                }
            }
        }
    }
}

