class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
            int rest = prefix[i] % k;
            if (i >= 2 && rest == 0) {
                return true;
            }
            if (map.containsKey(rest)) {
                if (i - map.get(rest) > 1) {
                    return true;
                }
            } else {
                map.put(rest, i);
            }
        }
        return false;
    }
}
