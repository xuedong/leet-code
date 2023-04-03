class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int ans = 0;

        int i = 0, j = people.length - 1;
        while (i < j) {
            if (people[i] + people[j] > limit) {
                j--;
                ans++;
            } else {
                j--;
                i++;
                ans++;
            }
        }
        
        if (i == j) ans++;
        
        return ans;
    }
}
