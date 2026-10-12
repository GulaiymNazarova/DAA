import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class linkedListCycle {
    public boolean hasCycle(ListNode head) {
        boolean answer = false;
        HashSet<ListNode> seen = new HashSet<ListNode>();
        ListNode current = head;

        if (head == null) {
            return false;
        }

        while (current != null) {
            if (seen.contains(current) == true) {
                answer = true;
                return answer;
            } else {
                seen.add(current);
            }
            current = current.next;
        }

        return answer;
    }
}