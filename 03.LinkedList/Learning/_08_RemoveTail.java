public class _08_RemoveTail {
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

    public static Node removeTail(Node head) {
        if(head == null || head.next == null) return null;
        Node temp = head;

        while(temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7 };
        Node head = convertArrToLL(arr);
        System.out.println(head.data);

        Node head2 = removeTail(head);

        Node temp = head2;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
