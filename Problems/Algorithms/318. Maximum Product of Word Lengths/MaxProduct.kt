class Solution {
    fun maxProduct(words: Array<String>): Int {
        var ans = 0
        for (i in 0..words.size-1) {
            for (j in i+1..words.size-1) {
                var flag = true
                for (ch in words[i]) {
                    if (words[j].contains(ch)) {
                        flag = false
                        break
                    }
                }
                if (flag) {
                    ans = maxOf(ans, words[i].length * words[j].length)
                }
            }
        }
        
        return ans
    }
}

