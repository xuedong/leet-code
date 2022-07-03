class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        
        int diff = nums[1] - nums[0];
        int ans = diff == 0 ? 1 : 2;
        for (int i = 2; i < n; i++) {
            int curr = nums[i] - nums[i-1];
            if ((curr > 0 && diff <= 0) || (curr < 0 && diff >= 0)) {
                ans++;
                diff = curr;
            }
        }
        
        return ans;
    }
}

