class Solution {
    fun calculateTime(keyboard: String, word: String): Int {
        val map: MutableMap<Char, Int> = mutableMapOf()
        for (i in 0..keyboard.length-1) {
            val char = keyboard.get(i)
            map.put(char, i)
        }

        var curr = 0
        var ans = 0
        for (char in word) {
            ans += Math.abs(curr - map.get(char)!!)
            curr = map.get(char)!!
        }

        return ans
    }
}
