class MyHashSet() {
    
    private val HASHSIZE = 256
    private val hashSet: Array<MutableList<Int>> = Array(HASHSIZE) { mutableListOf<Int>() }
    private var curr: MutableList<Int> = mutableListOf()

    fun add(key: Int) {
        if (!contains(key)) {
            curr.add(key)
        }
    }

    fun remove(key: Int) {
        if (contains(key)) {
            curr.remove(key)
        }
    }

    fun contains(key: Int): Boolean {
        curr = hashSet[key % HASHSIZE]
        return curr.contains(key)
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */
