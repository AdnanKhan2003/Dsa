public class _02_ConvertArrToLL {
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
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 6, 7, 9 };
        Node head = new Node(arr[0]);

        System.out.println("Node head is: " + head.data);
        Node head2 = convertArrToLL(arr);
        System.out.println(head2.data);
    }
}
