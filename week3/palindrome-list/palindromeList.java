import java.util.ArrayList;

class palindromeList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode current = head;

        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        int size = list.size();
        int left = 0;
        int right = size - 1;

        while (left < right) {
            int leftVal = list.get(left);
            int rightVal = list.get(right);
            if (leftVal != rightVal) {
                return false;
            }
            left = left + 1;
            right = right - 1;
        }

        return true;
    }
}