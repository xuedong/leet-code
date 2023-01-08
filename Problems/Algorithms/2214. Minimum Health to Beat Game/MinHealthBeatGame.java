class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long ans = 0;
        int max = 0;
        for (int i = 0; i < damage.length; i++) {
            ans += damage[i];
            max = Math.max(max, damage[i]);
        }
        return ans - Math.min(max, armor) + 1;
    }
}
