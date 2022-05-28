class Solution {
    fun largestWordCount(messages: Array<String>, senders: Array<String>): String {
        val map: MutableMap<String, Int> = mutableMapOf()
        
        var max = 0
        for (i in 0.. messages.size-1) {
            val count = messages[i].split(" ").size
            map.put(senders[i], map.getOrDefault(senders[i], 0) + count)
            max = maxOf(max, map.get(senders[i])!!)
        }
        
        var best = ""
        for (sender in map.keys) {
            if (map.get(sender) == max) {
                best = maxOf(best, sender)
            }
        }
        
        return best
    }
}

