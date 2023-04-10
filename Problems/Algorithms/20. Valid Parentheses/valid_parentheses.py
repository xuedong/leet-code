#!/usr/bin/env python3

from collections import deque


class Solution:
    def isValid(self, s: str) -> bool:
        stack = deque()
        
        for ch in s:
            if ch in ['(', '[', '{']:
                stack.append(ch)
            else:
                end = ''
                if ch == ')':
                    end = '('
                if ch == ']':
                    end = '['
                if ch == '}':
                    end = '{'

                if len(stack) == 0:
                    return False
                if end != stack.pop():
                    return False
        
        return len(stack) == 0
