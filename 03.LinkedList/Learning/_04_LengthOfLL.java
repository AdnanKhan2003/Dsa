public class _04_LengthOfLL {
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

    public static int getLengthOfLL(Node head) {
        int count = 0;

        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            count++;
        }

        return count;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 6, 7, 9 };
        Node head = convertArrToLL(arr);
        System.out.println("Head is: " + head.data);

        int l = getLengthOfLL(head);
        System.out.println("Length of LL is: " + l);
    }
}

// TC: O(n)