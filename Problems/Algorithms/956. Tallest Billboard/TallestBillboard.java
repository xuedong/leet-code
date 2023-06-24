class Solution {
    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for (int rod : rods) {
            Map<Integer, Integer> curr = new HashMap<>(map);

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int diff = entry.getKey();
                int taller = entry.getValue();
                int shorter = taller - diff;

                int currTaller = curr.getOrDefault(diff + rod, 0);
                curr.put(diff + rod, Math.max(currTaller, taller + rod));

                int currDiff = Math.abs(shorter + rod - taller);
                currTaller = Math.max(shorter + rod, taller);
                curr.put(currDiff, Math.max(currTaller, curr.getOrDefault(currDiff, 0)));
            }

            map = curr;
        }

        return map.getOrDefault(0, 0);
    }
}
