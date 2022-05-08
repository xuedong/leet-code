/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     constructor()
 *
 *     // Constructor initializes a single integer.
 *     constructor(value: Int)
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     fun isInteger(): Boolean
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     fun getInteger(): Int?
 *
 *     // Set this NestedInteger to hold a single integer.
 *     fun setInteger(value: Int): Unit
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     fun add(ni: NestedInteger): Unit
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     fun getList(): List<NestedInteger>?
 * }
 */

class NestedIterator(nestedList: List<NestedInteger>) {
    private val flattenedList: MutableList<Int> = mutableListOf()
    private var index: Int = 0
    
    init {
        flatten(nestedList)
    }
    
    private fun flatten(nestedList: List<NestedInteger>) {
        nestedList.forEach { nestedInteger ->
            if (nestedInteger.isInteger()) {
                flattenedList.add(nestedInteger.getInteger()!!)
            } else {
                flatten(nestedInteger.getList()!!)
            }
        }
    }
    
    fun next(): Int {
        return flattenedList[index++]
    }
    
    fun hasNext(): Boolean {
        return index < flattenedList.size
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * var obj = NestedIterator(nestedList)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
