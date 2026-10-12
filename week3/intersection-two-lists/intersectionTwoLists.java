public class intersectionTwoLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = 0;
        int lenB = 0;

        ListNode temp = headA;
        while (temp != null) {
            lenA = lenA + 1;
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            lenB = lenB + 1;
            temp = temp.next;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        if (lenA > lenB) {
            int diff = lenA - lenB;
            int i = 0;
            while (i < diff) {
                pA = pA.next;
                i = i + 1;
            }
        } else {
            int diff = lenB - lenA;
            int i = 0;
            while (i < diff) {
                pB = pB.next;
                i = i + 1;
            }
        }

        while (pA != null && pB != null) {
            if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }

        return null;
    }
}