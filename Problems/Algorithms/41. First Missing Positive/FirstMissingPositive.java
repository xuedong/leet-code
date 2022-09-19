class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0 || nums[i] > n) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            int rest = nums[i] % (n + 1);
            if (rest != 0) {
                nums[rest - 1] += n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] / (n + 1) == 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
