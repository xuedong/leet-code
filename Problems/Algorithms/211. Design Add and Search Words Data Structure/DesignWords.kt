class WordDictionary() {

    private val root = TrieNode()

    fun addWord(word: String) {
        var curr = root
        for (ch in word) {
            curr = curr.children.computeIfAbsent (ch) {
                TrieNode()
            }
        }
        curr.isWord = true
    }

    fun search(word: String): Boolean {
        return search(root, word, 0)
    }

    private fun search(node: TrieNode?, word: String, index: Int): Boolean {
        if (node == null) return false
        if (index == word.length) return node.isWord

        val ch = word[index]
        if (ch != '.') {
            return search(node.children[ch], word, index + 1)
        } else {
            for (child in node.children.values) {
                if (search(child, word, index + 1)) return true
            }
            return false
        }
    }

    private class TrieNode(
        val children: MutableMap<Char, TrieNode> = mutableMapOf(),
        var isWord: Boolean = false
    )

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */