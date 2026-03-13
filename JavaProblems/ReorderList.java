//* Definition for singly-linked list.
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

public void reorderList(ListNode head) {
    // find middle
    ListNode slow = head, fast = head.next;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // reverse second half
    ListNode second = slow.next;
    ListNode prev = slow.next = null;
    while (second != null) {
        ListNode temp = second.next;
        second.next = prev;
        prev = second;
        second = temp;
    }

    // merge two halfs
    ListNode first = head;
    second = prev;
    while (second != null) {
        ListNode temp1 = first.next, temp2 = second.next;
        first.next = second;
        second.next = temp1;
        first = temp1;
        second = temp2;
    }
}

static ListNode build(int[] arr) {
    ListNode head = new ListNode(arr[0]);
    ListNode curr = head;

    for (int i = 1; i < arr.length; i++) {
        curr.next = new ListNode(arr[i]);
        curr = curr.next;
    }

    return head;
}

static void print(ListNode head) {
    while (head != null) {
        System.out.print(head.val + " ");
        head = head.next;
    }
    System.out.println();
}

// Overall time complexity: O(n), space complexity: O(1)
void main() {
    int[] arr = {1, 2, 3, 4};
    ListNode head = build(arr);
    reorderList(head);
    print(head);


    arr = new int[]{1, 2, 3, 4, 5};
    head = build(arr);
    reorderList(head);
    print(head);
}