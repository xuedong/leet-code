class Solution {
    fun digArtifacts(n: Int, artifacts: Array<IntArray>, dig: Array<IntArray>): Int {
        val set = mutableSetOf<String>()
        for (cell in dig) {
            set.add(cell[0].toString()+" "+cell[1].toString())
        }
        
        var ans = 0
        for (artifact in artifacts) {
            var flag = true
            for (i in artifact[0]..artifact[2]) {
                for (j in artifact[1]..artifact[3]) {
                    if (set.contains(i.toString()+" "+j.toString())) continue
                    else flag = false
                }
            }
            if (flag) ans++
        }
        
        return ans
    }
}

