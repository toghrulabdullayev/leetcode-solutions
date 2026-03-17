public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    HashMap<Character, Character> closeToOpen = new HashMap<>();

    closeToOpen.put(')', '(');
    closeToOpen.put(']', '[');
    closeToOpen.put('}', '{');

    for (char c : s.toCharArray()) {
        // if it's a closing bracket
        if (closeToOpen.containsKey(c)) {
            // if the last element in stack is the pair for that closing bracket
            if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                stack.pop(); // remove as the pairs match
            } else {
                return false;
            }
        } else {
            // (BEGINS HERE) opening closing brackets are added to stack
            stack.push(c);
        }
    }

    return stack.isEmpty();
}

// Overall time complexity: O(n)
void main() {
    System.out.println(isValid("()[]{}"));
    System.out.println(isValid("(]"));
    System.out.println(isValid("([{}])"));
    System.out.println(isValid("([)]"));
}
