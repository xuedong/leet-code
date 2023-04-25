class SmallestInfiniteSet {
    private HashSet<Integer> exists;
    private PriorityQueue<Integer> hp;
    private Integer curr;

    public SmallestInfiniteSet() {
        exists = new HashSet<>();
        hp = new PriorityQueue<>();
        curr = 1;
    }
    
    public int popSmallest() {
        int ans;

        if (!hp.isEmpty()) {
            ans = hp.poll();
            exists.remove(ans);
        } else {
            ans = curr;
            curr++;
        }

        return ans;
    }
    
    public void addBack(int num) {
        if (curr <= num || exists.contains(num)) {
            return;
        }

        hp.offer(num);
        exists.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */