class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int currGas = 0;
        
        int startPoint = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            currGas += gas[i] - cost[i];

            if (currGas < 0) {
                currGas = 0;
                startPoint = i + 1;
            }
        }

        if (totalGas < 0) return -1;
        return startPoint;
    }
}
