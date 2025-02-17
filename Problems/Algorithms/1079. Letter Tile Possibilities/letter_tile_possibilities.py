#!/usr/bin/env python3


class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        sequences = set()
        used = [False] * len(tiles)

        self.__generate(tiles, "", used, sequences)

        return len(sequences) - 1

    def __generate(self, tiles: str, curr: str, used: list, sequences: set):
        sequences.add(curr)

        for pos, ch in enumerate(tiles):
            if not used[pos]:
                used[pos] = True
                self.__generate(tiles, curr + ch, used, sequences)
                used[pos] = False
