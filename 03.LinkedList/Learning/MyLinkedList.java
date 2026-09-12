public class MyLinkedList {
    Node head = null;
    int size = 0;

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

    public void convertArrToLL(int[] arr) {
        if(arr == null || arr.length == 0) {
            head = null;
            return;
        }

        head = new Node(arr[0]);
        Node mover = head;
        size = arr.length;

        for(int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
    }

    public void printLL() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void deleteHead() {
        if(head == null) return;
        head = head.next;
        size--;
    }

    public void deleteTail() {
        if(head == null) return;
        if(head.next == null) {
            head = null;
            size--;
            return;
        }

        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    public void deleteAtK(int k) {
        if(head == null || k < 1) return;

        if(k == 1) {
            head = head.next;
            size--;
            return;
        }

        Node temp = head;
        Node prev = null;
        int count = 0;


        while(temp != null) {
            count++;
            if(count == k) {
                prev.next = prev.next.next;
                size--;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public void deleteAtIndex(int i) {
        if(head == null || i < 0) return;

        if(i == 0) {
            head = head.next;
            size--;
            return;
        }

        Node temp = head;
        Node prev = null;
        int count = 0;

        while(temp != null) {
            if(count == i) {
                prev.next = prev.next.next;
                size--;
                break;
            }
            count++;
            prev = temp;
            temp = temp.next;
        }
    }

    public void deleteVal(int val) {
        if(head == null) return;
        if(head.data == val) {
            head = head.next;
            size--;
            return;
        }

        Node temp = head;
        Node prev = null;
        while(temp != null) {
            if(temp.data == val) {
                prev.next = prev.next.next;
                size--; 
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public void insertHead(int val) {
        Node newNode = new Node(val, head);
        head = newNode;
        size++;
    }

    public void insertTail(int val) {
        if (head == null) return;

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val, null);
        size++;
    }

    public void insertAtK(int k, int val) {
        if(head == null || k < 1 || k > size) return;

        if(k == 1) {
            Node newNode = new Node(val, head);
            head = newNode;
            size++;
            return;
        }

        Node temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            if(count == k-1) {
                Node newNode = new Node(val, temp.next);
                temp.next = newNode;
                size++;
                break;
            }
            temp = temp.next;
        }
    }

    public void insertAtIndex(int index, int val) {
        if(head == null || index < 0 || index >= size) return;

        if(index == 0) {
            Node newNode = new Node(val, head);
            head = newNode;
            size++;
            return;
        }

        Node temp = head;
        int count = 0;
        while(temp != null) {
            if(count == index-1) {
                Node newNode = new Node(val, temp.next);
                temp.next = newNode;
                size++;
                break;
            }
            count++;
            temp = temp.next;
        }
    }

    public void insertBeforeValue(int target, int val) {
        if(head == null) return;

        Node temp = head;
        while(temp != null) {
            if(temp.next.data == target) {
                Node newNode = new Node(val, temp.next);
                temp.next = newNode;
                size++;
                return;
            }
            temp = temp.next;
        }
    }

    public int get(int index) {
        if(index < 0 || index >= size) return -1;

        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 8, 9, 12, 2, 6 };
        MyLinkedList obj = new MyLinkedList();
        obj.convertArrToLL(arr);
        // obj.printLL();

        /* 1. Delete Head */
        // obj.printLL();
        // obj.deleteHead();
        // obj.printLL();

        /* 2. Delete Tail */
        // obj.printLL();
        // obj.deleteTail();
        // obj.printLL();

        /* 3. Delete at K */
        // obj.printLL(); 
        // obj.deleteAtK(1);
        // obj.deleteAtK(2);
        // obj.printLL(); 

        /* 4. Delete at i */
        // obj.printLL();
        // obj.deleteAtIndex(0);
        // obj.deleteAtIndex(2);
        // obj.printLL();

        /* 5. Delete value */
        // obj.printLL();
        // obj.deleteVal(1);
        // obj.deleteVal(9);
        // obj.printLL();

        /* 1. Insert Head */
        // obj.printLL();
        // System.out.println(obj.size);
        // obj.insertHead(99);
        // System.out.println(obj.size);
        // obj.printLL();

        /* 2. Insert Tail */
        // obj.printLL();
        // System.out.println(obj.size);
        // obj.insertTail(100);
        // System.out.println(obj.size);
        // obj.printLL();

        /* 3. Insert at K */
        // obj.printLL();
        // System.out.println(obj.size);
        // obj.insertAtK(4, 33);
        // obj.insertAtK(1, 0);
        // System.out.println(obj.size);
        // obj.printLL();

        /* 4. Insert at i */
        // obj.printLL();
        // System.out.println(obj.size);
        // obj.insertAtIndex(0, 22);
        // obj.insertAtIndex(3, 232);
        // System.out.println(obj.size);
        // obj.printLL();

        /* 5. Insert value */
        // obj.printLL();
        // System.out.println(obj.size);
        // obj.insertBeforeValue(12, 33);
        // System.out.println(obj.size);
        // obj.printLL();

        /* Get by Index */
        // obj.printLL();
        // System.out.println(obj.get(0));
        // System.out.println(obj.get(2));
        // obj.printLL();
    }
}