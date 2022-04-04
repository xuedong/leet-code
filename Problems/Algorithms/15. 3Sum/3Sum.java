class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n <= 2) return new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for (int i = 0; i <= n-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    
                    k--;
                    while (j < k && nums[k] == nums[k+1]) {
                        k--;
                    }
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        
        return results;
    }
}

