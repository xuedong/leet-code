#!/usr/bin/env python3

from typing import List
from collections import deque


class Solution:
    def findAllRecipes(self, recipes: List[str], ingredients: List[List[str]], supplies: List[str]) -> List[str]:
        available = set(supplies)

        queue = deque(range(len(recipes)))
        ans = []

        last_size = -1
        while len(available) > last_size:
            size = len(queue)
            last_size = len(available)

            while size > 0:
                size -= 1
                recipe = queue.popleft()

                if all(ingredient in available for ingredient in ingredients[recipe]):
                    available.add(recipes[recipe])
                    ans.append(recipes[recipe])
                else:
                    queue.append(recipe)

        return ans
