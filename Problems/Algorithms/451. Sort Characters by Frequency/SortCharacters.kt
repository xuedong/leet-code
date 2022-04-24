class Solution {
    fun frequencySort(s: String): String {
        val count: MutableMap<Char, Int> = mutableMapOf()
        for (ch in s) {
            count.put(ch, count.getOrDefault(ch, 0) + 1)
        }
        
        val heap = PriorityQueue<Char>({ a, b -> count.get(b)!! - count.get(a)!! })
        heap.addAll(count.keys)
        
        val sb = StringBuilder()
        while (!heap.isEmpty()) {
            val ch = heap.poll()
            sb.append(ch.toString().repeat(count[ch]!!))
        }
        
        return sb.toString()
    }
}

