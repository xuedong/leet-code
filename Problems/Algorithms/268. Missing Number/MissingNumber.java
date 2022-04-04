class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        
        for (int num : nums) {
            ans ^= num;
        }
        
        for (int num = 0; num <= nums.length; num++) {
            ans ^= num;
        }
        
        return ans;
    }
}

