class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int indexNonZeros = 0;
        int numZeros = 0;
        
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[indexNonZeros] = nums[i];
                indexNonZeros++;
            } else {
                numZeros++;
            }
        }
        
        for (int i = length-1; i >= length-numZeros; i--) {
            nums[i] = 0;
        }
    }
}

