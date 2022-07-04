class Solution {
    
    private int[] nums;
    private Random rng;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rng = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int ans = 0;
        for (int i = 0; i < this.nums.length; i++) {
            if (this.nums[i] == target) {
                count++;
                if (rng.nextInt(count) == count-1) {
                    ans = i;
                }
            }
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
