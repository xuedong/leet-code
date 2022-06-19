class Solution {
    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        products.sort()
        
        val n = products.size
        var start = 0
        val results: MutableList<MutableList<String>> = mutableListOf()
        
        var prefix = StringBuilder()
        for (ch in searchWord) {
            prefix.append(ch)
            
            val curr = lowerBound(products, start, prefix.toString())
            val m = prefix.length
            
            results.add(mutableListOf())
            for (i in curr..minOf(curr+3, n)-1) {
                if (products[i].length < m || products[i].substring(0, m) != prefix.toString()) {
                    break
                }
                
                results.get(results.size-1).add(products[i])
            }
            
            start = curr
        }
        
        return results
    }
    
    private fun lowerBound(products: Array<String>, start: Int, word: String): Int {
        var left = start
        var right = products.size
        
        while (left < right) {
            val mid = left + (right - left) / 2
            
            if (products[mid] >= word) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        
        return left
    }
}

