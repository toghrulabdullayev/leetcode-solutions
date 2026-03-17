def isValid(s: str) -> bool:
    stack = []
    closeToOpen = {")": "(", "]": "[", "}": "{"}

    for c in s:
        # equivalent of "if c in closeToOpen.keys():"
        # if it's a closing bracket
        if c in closeToOpen:
            # if the last element in stack is the pair for that closing bracket
            if stack and stack[-1] == closeToOpen[c]:
                stack.pop() # remove as the pairs match
            else:
                return False
        else:
            # (BEGINS HERE) opening closing brackets are added to stack
            stack.append(c)

    return not stack

# Overall time complexity: O(n)
print(isValid("()[]{}"))
print(isValid("(]"))
print(isValid("([{}])"))
print(isValid("([)]"))
