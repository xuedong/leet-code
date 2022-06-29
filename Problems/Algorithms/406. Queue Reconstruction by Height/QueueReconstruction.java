class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        
        List<int[]> results = new LinkedList<>();
        for (int[] curr : people) {
            results.add(curr[1], curr);
        }
        
        return results.toArray(new int[people.length][]);
    }
}

