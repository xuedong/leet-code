class Solution {
    private int[] values;
    private Map<Integer, Integer> counter;
    
    public void swap(int a, int b) {
        int temp = values[a];
        values[a] = values[b];
        values[b] = temp;
    }
    
    public int partition(int left, int right, int pivot) {
        int freq = counter.get(values[pivot]);
        
        swap(pivot, right);
        
        int store = left;
        for (int i = left; i <= right; i++) {
            if (counter.get(values[i]) < freq) {
                swap(store, i);
                store++;
            }
        }
        
        swap(store, right);
        
        return store;
    }
    
    public void quickSelect(int left, int right, int position) {
        if (left == right) return;
        
        Random rng = new Random();
        int pivot = left + rng.nextInt(right-left);
        
        pivot = partition(left, right, pivot);
        if (pivot == position) {
            return;
        } else if (pivot > position) {
            quickSelect(left, pivot-1, position);
        } else {
            quickSelect(pivot+1, right, position);
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        
        int n = counter.size();
        values = new int[n];
        int i = 0;
        for (int num : counter.keySet()) {
            values[i++] = num;
        }
        
        quickSelect(0, n-1, n-k);
        
        return Arrays.copyOfRange(values, n-k, n);
    }
}

