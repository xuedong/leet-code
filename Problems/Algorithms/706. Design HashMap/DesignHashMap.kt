class MyHashMap() {
    
    var hashSize: Int = 1000001
    var hashMap: Array<Int?> = arrayOfNulls<Int>(hashSize)
    init {
        this.hashSize = hashSize
        this.hashMap = hashMap
    }
    
    private fun computeHash(key: Int): Int {
        return key % this.hashSize
    }

    fun put(key: Int, value: Int) {
        this.hashMap[computeHash(key)] = value
    }

    fun get(key: Int): Int {
        val hashKey = computeHash(key)
        if (this.hashMap[hashKey] == null) return -1
        else return this.hashMap[hashKey]!!
    }

    fun remove(key: Int) {
        this.hashMap[computeHash(key)] = null
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */
