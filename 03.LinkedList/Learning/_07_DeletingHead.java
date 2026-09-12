public class _07_DeletingHead {
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

    public static Node removeHead(Node head) {
        if(head == null) return head;
        return head.next;
    }
    public static void main(String[] args) {
        int[] arr = { 12, 5, 92, 9 };
        Node head = convertArrToLL(arr);

        Node newHead = removeHead(head);

        Node temp = newHead;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}