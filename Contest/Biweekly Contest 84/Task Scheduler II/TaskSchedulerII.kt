class Solution {
    fun taskSchedulerII(tasks: IntArray, space: Int): Long {
        val map: MutableMap<Int, Long> = mutableMapOf()
        
        var ans: Long = 0
        for (task in tasks) {
            if (!map.containsKey(task)) {
                ans++
            } else {
                val last = map.get(task)!!
                if (ans - last >= space) {
                    ans++
                } else {
                    ans = last + space + 1
                }
            }
            map.put(task, ans)
        }
        
        return ans
    }
}

