class Solution {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val x1 = coordinates[0][0]
        val y1 = coordinates[0][1]
        val x2 = coordinates[1][0]
        val y2 = coordinates[1][1]
        
        if (x1 == x2) {
            for (coord in coordinates) {
                if (coord[0] != x1) return false
            }
            return true
        }
        
        val k = (y2 - y1).toDouble() / (x2 - x1).toDouble()
        val b = (y1*x2 - y2*x1).toDouble() / (x2 - x1).toDouble()
        for (coord in coordinates) {
            if (k * coord[0].toDouble() + b != coord[1].toDouble()) return false
        }
        return true
    }
}

