public class _05_PalindromeLL {
    public static class ListNode {
        int value;
        ListNode next;

        ListNode(int value1, ListNode next1) {
            this.value = value1;
            this.next = next1;
        }

        ListNode(int value1) {
            this.value = value1;
            this.next = null;
        }
    }

    public static ListNode convertArrToLL(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;
        for(int i = 1; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            mover.next = newNode;
            mover = newNode;
        }
        return head;
    }

    public static void printLL(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode reverseLL(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public static boolean isPalidrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        if(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverseLL(slow.next);
        ListNode first = head;
        ListNode second = newHead;

        while(second != null) {
            if(first.value != second.value) {
                reverseLL(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }

        reverseLL(newHead);
        return true;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2, 1 };
        ListNode head = convertArrToLL(arr);

        Boolean result = isPalidrome(head);
        System.out.println("LinkedList is Palindrome?: " + result);
    }
}
