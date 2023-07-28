class Solution {
    private int maxDiff(int[] nums, int left, int right) {
        if (left == right) {
            return nums[right];
        }

        int scoreLeft = nums[left] - maxDiff(nums, left+1, right);
        int scoreRight = nums[right] - maxDiff(nums, left, right-1);

        return Math.max(scoreLeft, scoreRight);
    }

    public boolean PredictTheWinner(int[] nums) {
        return maxDiff(nums, 0, nums.length-1) >= 0;
    }
}
