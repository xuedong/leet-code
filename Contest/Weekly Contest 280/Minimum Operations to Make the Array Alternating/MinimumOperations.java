class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> mapEven = new HashMap<Integer, Integer>();
        Map<Integer, Integer> mapOdd = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i += 2) {
            int key = nums[i];
            if (mapEven.containsKey(key)) {
                int frequency = mapEven.get(key);
                frequency += 1;
                mapEven.put(key, frequency);
            } else {
                mapEven.put(key, 1);
            }
        }
        
        for (int i = 1; i < nums.length; i += 2) {
            int key = nums[i];
            if (mapOdd.containsKey(key)) {
                int frequency = mapOdd.get(key);
                frequency += 1;
                mapOdd.put(key, frequency);
            } else {
                mapOdd.put(key, 1);
            }
        }
        
        int countEven = 0, countSecondEven = 0, bestEven = -1, secondEven = -1; 
        for (Map.Entry<Integer, Integer> val: mapEven.entrySet()) {
            if (countEven < val.getValue()) {
                secondEven = bestEven;
                countSecondEven = countEven;
                bestEven = val.getKey();
                countEven = val.getValue();
            } else if (countSecondEven < val.getValue()) {
                secondEven = val.getKey();
                countSecondEven = val.getValue();
            }
        }
        
        int countOdd = 0, countSecondOdd = 0, bestOdd = -1, secondOdd = -1;
        for (Map.Entry<Integer, Integer> val: mapOdd.entrySet()) {
            if (countOdd < val.getValue()) {
                secondOdd = bestOdd;
                countSecondOdd = countOdd;
                bestOdd = val.getKey();
                countOdd = val.getValue();
            } else if (countSecondOdd < val.getValue()) {
                secondOdd = val.getKey();
                countSecondOdd = val.getValue();
            }
        }
        
        int resultEven = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                if (nums[i] != bestEven) {
                    resultEven++;
                }
            } else if (bestEven == bestOdd) {
                if (nums[i] != secondOdd) {
                    resultEven++;
                }
            } else {
                if (nums[i] != bestOdd) {
                    resultEven++;
                }
            }
        }
        
        int resultOdd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i] != bestOdd) {
                    resultOdd++;
                }
            } else if (bestEven == bestOdd) {
                if (nums[i] != secondEven) {
                    resultOdd++;
                }
            } else {
                if (nums[i] != bestEven) {
                    resultOdd++;
                }
            }
        }
        
        return Math.min(resultEven, resultOdd);
    }
}

