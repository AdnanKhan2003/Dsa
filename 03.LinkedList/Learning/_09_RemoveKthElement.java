public class _09_RemoveKthElement {
    public static class Node {
        int data;
        Node next;

        Node(int data1, Node next1){
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

    public static Node removeKthElement(Node head, int k) {
        int count = 0;
        Node temp = head;

        while(temp != null) {
            count++;

            if(count == k-1) {
                temp.next = temp.next.next;
            }
        }

        return temp;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9 };
        Node head = convertArrToLL(arr);

        Node newHead = removeKthElement(head, 3);

        Node temp = newHead;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
