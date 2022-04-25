// Kotlin Iterator reference:
// https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/

class PeekingIterator(iterator: Iterator<Int>): Iterator<Int> {
    var iter = iterator
    var num: Int? = null
    
    fun peek(): Int {
    	num = next()
        return num ?: -1
    }
    
    override fun next(): Int {
        if (num == null) {
            return iter.next()
        } else {
            val temp = num
            num = null
            return temp!!
        }
    }
    
    override fun hasNext(): Boolean {
        return iter.hasNext() || num != null
    }
}

/**
 * Your PeekingIterator object will be instantiated and called as such:
 * var obj = PeekingIterator(arr)
 * var param_1 = obj.next()
 * var param_2 = obj.peek()
 * var param_3 = obj.hasNext()
 */
