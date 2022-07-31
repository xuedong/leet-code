class NumArray {
    
    private int[] segmentTree;
    private int size;

    public NumArray(int[] nums) {
        size = nums.length;
        segmentTree = new int[size*2];
        buildTree(nums);
    }
    
    private void buildTree(int[] nums) {
        for (int i = size, j = 0; i < 2 * size; i++, j++) {
            segmentTree[i] = nums[j];
        }
        
        for (int i = size - 1; i > 0; i--) {
            segmentTree[i] = segmentTree[2*i] + segmentTree[2*i+1];
        }
    }
    
    public void update(int index, int val) {
        index += size;
        segmentTree[index] = val;
        
        while (index > 0) {
            if (index % 2 == 0) {
                segmentTree[index/2] = segmentTree[index] + segmentTree[index+1]; 
            } else {
                segmentTree[index/2] = segmentTree[index-1] + segmentTree[index];
            }
            
            index /= 2;
        }
    }
    
    public int sumRange(int left, int right) {
        left += size;
        right += size;
        
        int sum = 0;
        while (left <= right) {
            if (left % 2 == 1) {
                sum += segmentTree[left];
                left++;
            }
            if (right % 2 == 0) {
                sum += segmentTree[right];
                right--;
            }
            
            left /= 2;
            right /= 2;
        }
        
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
