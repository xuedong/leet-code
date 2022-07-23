class Solution {
    
    int[] count;
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        mergeSort(nums, indices, 0, n-1);
        return Arrays.stream(count).boxed().toList();
    }
    
    private void mergeSort(int[] nums, int[] indices, int start, int end) {
        if (end <= start) return;
        
        int mid = start + (end - start) / 2;
        mergeSort(nums, indices, start, mid);
        mergeSort(nums, indices, mid+1, end);
        
        merge(nums, indices, start, mid, mid+1, end);
    }
    
    private void merge(int[] nums, int[] indices, int start1, int end1, int start2, int end2) {
        int start = start1;
        int rightCount = 0;
        
        int i = start1, j = start2, k = 0;
        int[] temp = new int[end2-start1+1];
        while (i <= end1 || j <= end2) {
            if (i > end1) {
                temp[k++] = indices[j++];
            } else if (j > end2) {
                temp[k++] = indices[i];
                count[indices[i++]] += rightCount;
            } else if (nums[indices[i]] > nums[indices[j]]) {
                temp[k++] = indices[j++];
                rightCount++;
            } else {
                temp[k++] = indices[i];
                count[indices[i++]] += rightCount;
            }
        }
        
        for (int l = 0; l < temp.length; l++) {
            indices[start+l] = temp[l];
        }
    }
    
}

