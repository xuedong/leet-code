class MyHashSet:

    def __init__(self):
        self.hs = 0

    def add(self, key: int) -> None:
        self.hs |= (1 << key)

    def remove(self, key: int) -> None:
        self.hs &= ~(1 << key)

    def contains(self, key: int) -> bool:
        return (self.hs >> key) & 1


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
