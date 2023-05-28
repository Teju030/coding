class Solution:
    def isValid(self, s: str) -> bool:
        hashmap = {'(': ')', '[': ']', '{': '}'}
        stack = list()

        for par in s:
            if par in hashmap:
                stack.append(par)
            elif stack and par == hashmap[stack[-1]]:
                stack.pop()
            else:
                return False
        return False if stack else True