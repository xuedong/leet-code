class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int x : changed) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        Arrays.sort(changed);
        int[] ans = new int[n / 2];
        int index = 0;
        for (int x : changed) {
            if (map.get(x) == 0) {
                continue;
            }
            if (map.getOrDefault(2 * x, 0) == 0) {
                return new int[0];
            }
            if (x == 0) {
                if (map.get(x) % 2 == 1) {
                    return new int[0];
                }
                ans[index++] = x;
                map.put(x, map.get(x) - 2);
            } else {
                ans[index++] = x;
                map.put(x, map.get(x) - 1);
                map.put(2 * x, map.get(2 * x) - 1);
            }
        }

        return ans;
    }
}
