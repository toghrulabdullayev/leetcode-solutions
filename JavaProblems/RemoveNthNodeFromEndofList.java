// Definition for singly-linked list.
static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public ListNode removeNthFromEnd(ListNode head, int n) {
    // creating a dummy Node to not lose the pointer to the first node
    ListNode dummy = new ListNode(0, head);
    ListNode left = dummy;
    ListNode right = head;

    // creating the gap = n between left and right pointers
    while (n > 0 && right != null) {
        right = right.next;
        n--;
    }

    // moving both till right is null to find the nth element from the end (left)
    while (right != null) {
        left = left.next;
        right = right.next;
    }

    //! left comes before the Node that should be deleted, in order to connect its edge to the node coming after the one to be deleted
    left.next = left.next.next; // delete (1 (left) -> 2 -> 3 => 1 (left) -> 3)
    return dummy.next; // returning first node (now updated)
}

// Overall time complexity: O(n)
void main() {
    var arr = new int[]{1, 2, 3, 4, 5};
    var head = new ListNode(1);
    var temp = head;
    for (int i = 1; i < arr.length; i++) {
        temp.next = new ListNode(arr[i]);
        temp = temp.next;
    }
    var res = removeNthFromEnd(head, 2);
    while (res != null) {
        System.out.println(res.val);
        res = res.next;
    }
}