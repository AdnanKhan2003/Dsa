public class _08_RemoveNBack {
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

    public static ListNode removeNthNode(ListNode head, int n) {
       ListNode sentinel = new ListNode(0);
       sentinel.next = head;
       
       int length = 0;
       ListNode temp = head;

       while(temp != null) {
        length++;
        temp = temp.next;
       }

       ListNode prev = sentinel;
       for(int i = 0; i < length - n; i++) {
        prev = prev.next;
       }
       prev.next = prev.next.next;
       return sentinel.next;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 6, 3, 4, 5, 6 };
        ListNode head = convertArrToLL(arr);

        printLL(head);
        ListNode deletedNthValues = removeNthNode(head, 2);
        printLL(deletedNthValues);

    }
}

// TC: O(n)
// SC: O(1) {
    

