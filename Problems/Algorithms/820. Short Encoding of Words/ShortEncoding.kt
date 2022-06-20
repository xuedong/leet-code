class Solution {
    fun minimumLengthEncoding(words: Array<String>): Int {
        val wordSet: HashSet<String> = hashSetOf(*words)
        for (word in words) {
            for (i in 1..word.length-1) {
                wordSet.remove(word.substring(i))
            }
        }
        
        var ans = 0
        for (word in wordSet) {
            println(word)
            ans += word.length + 1
        }
        return ans
    }
}

