class removeElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;
        ListNode check = dummy.next;

        while (check != null) {
            if (check.val == val) {
                current.next = check.next;
                check = check.next;
            } else {
                current = check;
                check = check.next;
            }
        }

        return dummy.next;
    }
}