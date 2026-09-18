public class _11_Add2Numbers2LL {
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int sum = 0;

            if(l1 != null) {
                sum += l1.value;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.value;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            temp.next = newNode;
            temp = newNode;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr1 = { 9, 9, 9, 9, 9, 9, 9 };
        int[] arr2 = { 9, 9, 9, 9 };

        ListNode l1 = convertArrToLL(arr1);
        ListNode l2 = convertArrToLL(arr2);

        printLL(l1);
        printLL(l2);

        ListNode reversedSum = addTwoNumbers(l1, l2);
        printLL(reversedSum);
    }
}

// TC: O(n)
// SC: O(n)