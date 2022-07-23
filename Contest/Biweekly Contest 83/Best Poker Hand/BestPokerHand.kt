class Solution {
    fun bestHand(ranks: IntArray, suits: CharArray): String {
        if (suits[0] == suits[1] && suits[0] == suits[2] && suits[0] == suits[3] && suits[0] == suits[4]) {
            return "Flush"
        }
        
        val map: MutableMap<Int, Int> = mutableMapOf()
        var best = 0
        for (i in 0..4) {
            map.put(ranks[i], map.getOrDefault(ranks[i], 0)+1);
            best = maxOf(best, map.get(ranks[i])!!)
        }
        
        if (best >= 3) {
            return "Three of a Kind"
        } else if (best == 2) {
            return "Pair"
        } else {
            return "High Card"
        }
    }
}

