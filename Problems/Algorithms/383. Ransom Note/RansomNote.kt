class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val mapRansom: MutableMap<Char, Int> = mutableMapOf()
        val mapMagazine: MutableMap<Char, Int> = mutableMapOf()
        
        ransomNote.forEach {
            mapRansom[it] = mapRansom.getOrDefault(it, 0) + 1
        }
        magazine.forEach {
            mapMagazine[it] = mapMagazine.getOrDefault(it, 0) + 1
        }
        
        for ((key, value) in mapRansom) {
            if (mapRansom[key]!! > mapMagazine.getOrDefault(key, 0)) {
                return false
            }
        }
        
        return true
    }
}

