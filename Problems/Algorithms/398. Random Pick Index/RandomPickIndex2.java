class Solution {

    private HashMap<Integer, List<Integer>> indices;
    private Random rng;
    
    public Solution(int[] nums) {
        this.rng = new Random();
        this.indices = new HashMap<Integer, List<Integer>>();
        
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!this.indices.containsKey(nums[i])) {
                this.indices.put(nums[i], new ArrayList<>());
            }
            this.indices.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        int size = indices.get(target).size();
        return indices.get(target).get(rng.nextInt(size));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
