class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length; 
        int left = 0, right = n-1;
        
        int start = -1, end = -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (right >= 0) {
            if (nums[left] < max) {
                end = left;
            } else {
                max = nums[left];
            }
            
            if (nums[right] > min) {
                start = right;
            } else {
                min = nums[right];
            }
            
            left++;
            right--;
        }

        return start != -1 ? end-start+1 : 0;
    }
}

