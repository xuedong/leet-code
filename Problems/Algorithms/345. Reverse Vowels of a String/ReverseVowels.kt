class Solution {
    fun reverseVowels(s: String): String {
        val vowels = "aeiouAEIOU"
        val chars = s.toCharArray()

        var i = 0
        var j = chars.size - 1
        while (i < j) {
            while (i < j && !vowels.contains(chars[i])) {
                i++
            }
            while (i < j && !vowels.contains(chars[j])) {
                j--
            }
            if (i < j) {
                chars[i] = chars[j].also { chars[j] = chars[i] }
                i++
                j--
            }
        }

        return String(chars)
    }
}
