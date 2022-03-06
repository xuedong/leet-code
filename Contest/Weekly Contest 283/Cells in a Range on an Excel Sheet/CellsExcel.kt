class Solution {
    fun cellsInRange(s: String): List<String> {
        var results = ArrayList<String>()
        
        for (ch in s[0]..s[3]) {
            for (num in s[1]..s[4]) {
                results.add(ch.toString()+num.toString())
            }
        }
        
        return results
    }
}

