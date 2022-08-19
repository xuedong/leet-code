class Solution {
    public boolean isPossible(int[] nums) {
        int n = nums.length;
        if (nums == null || n <= 0) return false;
        
        int curr = 0, prev = Integer.MIN_VALUE;
        int curr1 = 0, curr2 = 0, curr3 = 0;
        int prev1 = 0, prev2 = 0, prev3 = 0;
        int i = 0;
        while (i < n) {
            curr = nums[i];
            int count = 0;
            while (i < n && curr == nums[i]) {
                i++;
                count++;
            }
            
            if (prev + 1 != curr) {
                if (prev1 != 0 || prev2 != 0) return false;

                curr1 = count;
                curr2 = curr3 = 0;
            } else {
                if (count < prev1 + prev2) return false;

                curr2 = prev1;
                curr3 = prev2;
                int rest = count - prev1 - prev2;
                curr3 += Math.min(rest, prev3);
                curr1 = Math.max(0, count - prev1 - prev2 - Math.min(prev3, rest));
            }
            
            prev = curr;
            prev1 = curr1;
            prev2 = curr2;
            prev3 = curr3;
        }

        return prev1 == 0 && prev2 == 0;
    }
}
