public class _07_RemoveAllKElements {
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

    public static ListNode removeAllKElements(ListNode head, int value) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode current = sentinel;

        while(current != null && current.next != null) {
            if(current.next.value == value) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return sentinel.next;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 6, 3, 4, 5, 6 };
        ListNode head = convertArrToLL(arr);

        printLL(head);
        ListNode deletedKValues = removeAllKElements(head, 6);
        printLL(deletedKValues);

    }
}

// TC: O(n)
// SC: O(1)