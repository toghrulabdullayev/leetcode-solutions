// Definition for singly-linked list.
static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

//* Floyd's Tortoise and Hare algorithm (hare eventually catches up with tortoise if there is a cycle)
public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next; // tortoise moves by 1
        fast = fast.next.next; // hare moves by 2
        if (slow == fast) {
            return true;
        }
    }

    return false;
}

// Overall time complexity: O(n)
void main() {
    //! pos is used to "artificially" make a cycle for test cases
    // Test case 1: [3,2,0,-4] with cycle at index 1 (pos = 1)
    ListNode a1 = new ListNode(3);
    ListNode a2 = new ListNode(2);
    ListNode a3 = new ListNode(0);
    ListNode a4 = new ListNode(-4);
    a1.next = a2;
    a2.next = a3;
    a3.next = a4;
    a4.next = a2; // cycle back to a2
    System.out.println(hasCycle(a1)); // true

    // Test case 2: [1,2] with cycle at index 0 (pos = 0)
    ListNode b1 = new ListNode(1);
    ListNode b2 = new ListNode(2);
    b1.next = b2;
    b2.next = b1; // cycle back to b1
    System.out.println(hasCycle(b1)); // true

    // Test case 3: [1] with no cycle (pos = -1)
    ListNode c1 = new ListNode(1);
    System.out.println(hasCycle(c1)); // false

    // Test case 4: Empty list (head = null)
    System.out.println(hasCycle(null)); // false

    // Test case 5: [1,2,3,4] no cycle
    ListNode d1 = new ListNode(1);
    ListNode d2 = new ListNode(2);
    ListNode d3 = new ListNode(3);
    ListNode d4 = new ListNode(4);
    d1.next = d2;
    d2.next = d3;
    d3.next = d4;
    System.out.println(hasCycle(d1)); // false
}