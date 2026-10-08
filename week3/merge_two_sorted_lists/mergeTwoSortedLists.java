import java.util.ArrayList;
import java.util.Collections;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class mergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer> values = new ArrayList<>();

        ListNode current = list1;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        current = list2;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        Collections.sort(values);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (int i = 0; i < values.size(); i++) {
            ListNode newNode = new ListNode(values.get(i));
            tail.next = newNode;
            tail = newNode;
        }

        return dummy.next;
    }
}