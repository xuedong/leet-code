class Solution {
    fun findCircleNum(isConnected: Array<IntArray>?): Int {
        if (isConnected == null || isConnected.size == 0) {
            return 0
        }
        
        val n = isConnected.size
        val uf = UnionFind(n)
        for (i in 0..n-1) {
            for (j in 0..n-1) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j)
                }
            }
        }
        
        return uf.getCount()
    }
    
    private class UnionFind(size: Int) {
        private val root = IntArray(size) {i -> i}
        private val rank = IntArray(size) {i -> 1}
        private var count = size
        
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
                    rank[rootX] += 1
                }
                count--
            }   
        }
        
        fun getCount(): Int {
            return count
        }
    }
}

