public class _03_ReverseLL {
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
            ListNode temp = new ListNode(arr[i]);   
            mover.next = temp;
            mover = temp;
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
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ListNode head = convertArrToLL(arr);
        printLL(head);
        ListNode reversedHead = reverseLL(head);
        printLL(reversedHead);
    }
}

// TC: O(n)
// SC: O(1)
