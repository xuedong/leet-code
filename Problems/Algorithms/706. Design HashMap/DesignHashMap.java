class MyHashMap {

    int hashSize = 1000001;
    int[] hashMap = new int[hashSize];

    public MyHashMap() {
        this.hashSize = hashSize;
        this.hashMap = hashMap;
        Arrays.fill(this.hashMap, -1);
    }
    
    private int computeHash(int key) {
        return key % this.hashSize;
    }
    
    public void put(int key, int value) {
        int hashKey = computeHash(key);
        this.hashMap[hashKey] = value;
    }
    
    public int get(int key) {
        int hashKey = computeHash(key);
        if (this.hashMap[hashKey] == -1) {
            return -1;
        } else {
            return this.hashMap[hashKey];
        }
    }
    
    public void remove(int key) {
        int hashKey = computeHash(key);
        this.hashMap[hashKey] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
