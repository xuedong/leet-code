class Solution {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        val seen: BooleanArray = BooleanArray(26) { false }
        for (letter in letters) {
            seen[letter - 'a'] = true
        }
        
        var curr = target
        while (true) {
            curr++
            if (curr > 'z') curr = 'a'
            if (seen[curr - 'a']) return curr
        }
    }
}

