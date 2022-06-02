class Solution {
    fun minMutation(start: String, end: String, bank: Array<String>): Int {
        if (start == end) return 0
        
        val bankSet: HashSet<String> = hashSetOf()
        for (gene in bank) {
            bankSet.add(gene)
        }
        
        val charSet = charArrayOf('A', 'C', 'G', 'T')
        val visited: HashSet<String> = hashSetOf()
        
        val queue = ArrayDeque<String>()
        queue.add(start)
        
        var ans = 0
        while (!queue.isEmpty()) {
            val n = queue.size
            for (i in 0..n-1) {
                val curr = queue.removeFirst()
                if (curr == end) return ans
                
                val sb = StringBuilder(curr)
                for (j in 0..7) {
                    val oldChar = sb[j]
                    for (char in charSet) {
                        sb[j] = char
                        val newString = sb.toString()
                        if (!visited.contains(newString) && bankSet.contains(newString)) {
                            visited.add(newString)
                            queue.add(newString)
                        }
                    }
                    sb[j] = oldChar
                }
            }
            ans++
        }
        
        return -1
    }
}

