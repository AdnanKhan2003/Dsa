public class _02_ReturnMiddleLL {
    public static class ListNode {
        int data;
        ListNode next;

        ListNode(int data1, ListNode next1) {
            this.data = data1;
            this.next = next1;
        }

        ListNode(int data1) {
            this.data = data1;
            this.next = null;
        }
    }

    public static ListNode convertArrToLL(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;
        for(int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void printLL(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode getMiddleLL(ListNode head) {
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)  {
            slow = slow.next;
            fast = fast.next.next;

            temp = temp.next;
        }

        return slow;
    }
    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3, 5, 6, 8, 9 };
        int[] arr = { 1, 2, 3, 5, 6, 8, 9, 11 };
        ListNode head = convertArrToLL(arr);
        printLL(head);

        ListNode middleLL = getMiddleLL(head);
        printLL(middleLL);
    }
}

// TC: O(N): Fast running for N/2 operations
// SC: O(1)