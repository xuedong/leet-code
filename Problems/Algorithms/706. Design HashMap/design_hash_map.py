class MyHashMap:

    def __init__(self):
        self.hash_size = 1000001
        self.hash_map = [-1] * self.hash_size

    def _compute_hash(self, key):
        return key % self.hash_size

    def put(self, key: int, value: int) -> None:
        hash_key = self._compute_hash(key)
        self.hash_map[hash_key] = value

    def get(self, key: int) -> int:
        hash_key = self._compute_hash(key)
        if (hash_key != -1):
            return self.hash_map[key]

    def remove(self, key: int) -> None:
        hash_key = self._compute_hash(key)
        self.hash_map[key] = -1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
