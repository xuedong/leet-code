class Solution {
    public int removeElement(int[] nums, int val) {
        int ans = nums.length;
        int i = 0;
        while (i < ans) {
            if (val == nums[i]) {
                int temp = nums[i];
                nums[i] = nums[ans-1];
                nums[ans-1] = temp;
                ans--;
            } else {
                i++;
            }
        }
        
        return ans;
    }
}
