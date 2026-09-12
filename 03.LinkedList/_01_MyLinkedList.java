public class _01_MyLinkedList {
    Node head = null;
    int size = 0;

    public static class Node {
        int val;
        Node next;

        Node(int val1, Node next1) {
            this.val = val1;
            this.next = next1;
        }

        Node(int val1) {
            this.val = val1;
            this.next = null;
        }
    }

    public _01_MyLinkedList() {
        
    }
    
    public int get(int index) {
        if(index < 0 || index >= size) return -1;

        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val, head);
        head = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        if(head == null) {
            head = new Node(val);
            size++;
            return;
        }

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val, null);
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) return;

        if(index == 0) {
            Node newNode = new Node(val, head);
            head = newNode;
            size++;
            return;
        }

        Node temp = head;
        int count = 0;
        while(temp != null) {
            if(count ==  index - 1) {
                Node newNode = new Node(val, temp.next);
                temp.next = newNode;
                size++;
                break;
            }
            count++;
            temp = temp.next;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(head == null || index < 0 || index >= size) return;

        if(index == 0) {
            head = head.next;
            size--;
            return;
        }

        Node temp = head;
        int count = 0;
        Node prev = null;
        while(temp != null) {
            if(count == index) {
                prev.next = prev.next.next;
                size--;
                break;
            }
            count++;
            prev = temp;
            temp = temp.next;
        }
    }
}

/**
 * Your _01_MyLinkedList object will be instantiated and called as such:
 * _01_MyLinkedList obj = new _01_MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
  */
//  {
    
// }
