class removeDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode nextNode = head.next;

        while (nextNode != null) {
            if (current.val == nextNode.val) {
                current.next = nextNode.next;
                nextNode = nextNode.next;
            } else {
                current = nextNode;
                nextNode = nextNode.next;
            }
        }

        return head;
    }
}