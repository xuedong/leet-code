class UndergroundSystem {
    private Map<Integer, Pair<String, Integer>> checkIns;
    private Map<Pair<String, String>, int[]> times;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        times = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        String startStation = checkIns.get(id).getKey();
        int startTime = checkIns.get(id).getValue();
        checkIns.remove(id);

        Pair<String, String> pair = new Pair(startStation, stationName);
        int totalTime = times.containsKey(pair) ? times.get(pair)[0] : 0;
        int number = times.containsKey(pair) ? times.get(pair)[1] : 0;
        times.put(pair, new int[] {totalTime + t - startTime, number + 1});
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair<String, String> pair = new Pair(startStation, endStation);

        return (double) times.get(pair)[0] / times.get(pair)[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */