class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int longestStreak = 0;
        for (int num : nums) {
            if (!set.contains(num-1)) {
                int currStreak = 1;
                int curr = num;
                
                while (set.contains(curr+1)) {
                    curr++;
                    currStreak++;
                }
                
                longestStreak = Math.max(longestStreak, currStreak);
            }
        }
        
        return longestStreak;
    }
}

