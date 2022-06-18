from collections import defaultdict
Trie = lambda: defaultdict(Trie)


class WordFilter:

    def __init__(self, words: List[str]):
        self.trie = Trie()
        for weight, word in enumerate(words):
            for i in range(len(word)+1):
                node = self.trie
                node['weight'] = weight
                for char in word[i:]+'#'+word:
                    node = node[char]
                    node['weight'] = weight

    def f(self, prefix: str, suffix: str) -> int:
        node = self.trie
        for char in suffix+'#'+prefix:
            if char not in node:
                return -1
            node = node[char]
        return node['weight']


# Your WordFilter object will be instantiated and called as such:
# obj = WordFilter(words)
# param_1 = obj.f(prefix,suffix)
