class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            if (set.contains(2*curr)) return true;
            if (curr % 2 == 0 && set.contains(curr/2)) return true;
            set.add(arr[i]);
        }
        
        return false;
    }
}

