class Solution {
    fun findTheDifference(s: String, t: String): Char {
        if (s == "") return t[0]
        
        val arrS = s.toCharArray()
        val arrT = t.toCharArray()
        
        arrS.sort()
        arrT.sort()
        
        val n: Int = arrT.size
        for (i in 0..n-2) {
            if (arrS[i] != arrT[i]) return arrT[i]
        }
        return arrT[n-1]
    }
}

