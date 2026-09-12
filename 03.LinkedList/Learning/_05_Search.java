public class _05_Search {
    public static class Node {
        int data;
        Node next;

        Node(int data1, Node next1) {
            this.data = data1;
            this.next = next1;
        }

        Node(int data1) {
            this.data = data1;
            this.next = null;
        }
    }

    public static Node convertArrToLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    public static int doesElementExists(Node head, int value) {
        Node temp = head;
        while(temp != null) {
            if (temp.data == value) return 1;
            temp = temp.next;
        }

        return 0;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7 };
        Node head = convertArrToLL(arr);

        int getEle = doesElementExists(head, 5);
        System.out.println(getEle);
    }
}

// TC:
// Worst: O(n)
// Best: O(1)
// Avg: O(n/2)