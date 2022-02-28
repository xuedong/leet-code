class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val dictionary: HashSet<String> = wordList.toHashSet()
        val queue: Queue<String> = LinkedList<String>()
        
        if (!dictionary.contains(endWord)) {
            return 0
        }
        if (dictionary.contains(beginWord)) {
            dictionary.remove(beginWord)
        }
        queue.add(beginWord)
        
        var result: Int = 0
        while (!queue.isEmpty()) {
            result++
            
            val length: Int = queue.size
            for (i in 0..length-1) {
                val string: String = queue.poll()
                if (string.equals(endWord)) {
                    return result
                }
                val neighbors: List<String> = findNeighbors(string)
                for (neighbor in neighbors) {
                    if (dictionary.contains(neighbor)) {
                        queue.add(neighbor)
                        dictionary.remove(neighbor)
                    }
                }
            }
        }
        
        return 0
    }
    
    private fun findNeighbors(string: String): List<String> {
        val chars = string.toCharArray()
        val neighbors = mutableListOf<String>()
        
        for (i in 0..string.length-1){
            val current = string.get(i)
            for (ch in 'a'..'z'){
                chars[i] = ch
                val neighbor: String = String(chars)
                neighbors.add(neighbor)
            }
            chars[i] = current
        }
        
        return neighbors
    }
}

