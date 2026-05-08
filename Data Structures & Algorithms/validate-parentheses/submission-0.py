class Solution:
    def isValid(self, s: str) -> bool:
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        # Dictionary to hold matching pairs
        mapping = {')': '(', '}': '{', ']': '['}
        
        # Iterate through each character in the string
        for char in s:
            if char in mapping:
                if stack and stack[-1] == mapping[char]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(char)
        
        # If the stack is empty, all brackets were matched
        return not stack