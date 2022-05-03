class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        
        int left = n-1;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }
        
        stack.clear();
        
        int right = 0;
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        
        return right-left > 0 ? right-left+1 : 0;
    }
}

