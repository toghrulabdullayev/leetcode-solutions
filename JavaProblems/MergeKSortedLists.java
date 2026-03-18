import java.util.ArrayList;
import java.util.List;

// Definition for singly-linked list.
class ListNode {
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

// Overall time complexity: O(n * log k)
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // works like merge sort without recursions
        while (lists.length > 1) {
            int newSize = (lists.length + 1) / 2;
            ListNode[] mergedList = new ListNode[newSize];

            int idx = 0;
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1 < lists.length) ? lists[i + 1] : null; // if it has the second list during iteration

                // e.g. if the length of lists is 4, it becomes 2 and continues reducing by 2
                mergedList[idx++] = mergeList(l1, l2);
            }

            lists = mergedList; // update the lists
        }

        return lists[0];
    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); // preserves the merged linked list
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next; // iterating through linked list l1
            } else {
                tail.next = l2;
                l2 = l2.next; // iterating through linked list l2
            }
            tail = tail.next; // iterating through linked list tail
        }

        // as the l1 and l2 lists are sorted by default according to the description, just iterate through them one by one
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }

        return dummy.next;
    }
}