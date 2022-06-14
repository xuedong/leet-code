class Solution {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val n = words.size
        if (n == 1) return true
        
        val orderMap = IntArray(26) { 0 }
        for (i in 0..25) {
            orderMap[order.get(i)-'a'] = i
        }
        
        for (i in 0..n-2) {
            val curr = words[i]
            val next = words[i+1]
            for (j in 0..words[i].length-1) {
                if (j >= next.length) return false
                
                if (orderMap[curr.get(j)-'a'] > orderMap[next.get(j)-'a']) {
                    return false
                } else if (orderMap[curr.get(j)-'a'] < orderMap[next.get(j)-'a']) {
                    break
                }
            }
        }
        
        return true
    }
}

