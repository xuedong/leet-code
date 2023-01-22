class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0;

    public int confusingNumberII(int n) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        helper(n, 0);

        return ans;
    }

    private void helper(int n, long curr) {
        if (isConfusingNumber(curr)) {
            ans++;
        }

        for (Integer key : map.keySet()) {
            long next = curr * 10 + key;
            if (next <= n && next != 0) {
                helper(n, next);
            }
        }
    }

    private boolean isConfusingNumber(long n) {
        long source = n, target = 0;
        while (n > 0) {
            target = target * 10 + map.get((int) n % 10); 
            n /= 10;
        }
        return source != target;
    }
}
