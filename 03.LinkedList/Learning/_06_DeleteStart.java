public class _06_DeleteStart {
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
    public static Node deleteFirstHead(Node head) {
        Node temp = head;
        head = head.next;

        return head;
    }
    public static void main(String[] args) {
        int[] arr = { 3, 5, 7, 9, 11 };
        Node head = convertArrToLL(arr);
        System.out.println(head);

        Node newHead = deleteFirstHead(head);
        System.out.println("Newhead is: " + newHead);
    }
}
