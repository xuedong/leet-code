class UndergroundSystem() {
    
    private val checkins: MutableMap<Int, Pair<String, Int>> = mutableMapOf()
    private val trajectories: MutableMap<String, Pair<Int, Int>> = mutableMapOf()

    fun checkIn(id: Int, stationName: String, t: Int) {
        checkins[id] = stationName to t
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val from = checkins[id]!!
        val traj = from.first + "_" + stationName
        val duration = t - from.second
        
        val previous = trajectories[traj] ?: 0 to 0
        trajectories[traj] = previous.first + duration to previous.second + 1
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val pair = trajectories[startStation + "_" + endStation] ?: 0 to 0
        return pair.first.toDouble() / pair.second.toDouble()
    }

}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */
