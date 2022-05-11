class Solution {
    private val curr: StringBuilder
    private var res = 0
    private val vowels: CharArray = charArrayOf('a', 'e', 'i', 'o', 'u')
    
    init {
        curr = StringBuilder()
    }
    
    fun countVowelStrings(n: Int): Int {
        aux(n, 0)
        return res
    }
    
    private fun aux(n: Int, start: Int): Unit {
        if (curr.length == n) {
            res++
            return
        }
        
        for (i in start..4) {
            curr.append(vowels[i])
            aux(n, i)
            curr.deleteCharAt(curr.length-1)
        }
    }
}

