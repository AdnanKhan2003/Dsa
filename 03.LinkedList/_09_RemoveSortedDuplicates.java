public class _09_RemoveSortedDuplicates {
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
        if(arr == null || arr.length == 0) return null;
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
        if(head == null) return;

        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode removeDuplicates(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null) {
            if(temp.value == temp.next.value) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 3, 4 };
        ListNode head = convertArrToLL(arr);

        printLL(head);
        ListNode removedDuplicatesHead = removeDuplicates(head);
        printLL(removedDuplicatesHead);
    }
}

// TC: O(n)
// SC: O(1)