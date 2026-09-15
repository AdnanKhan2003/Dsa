import java.util.HashMap;

public class _06_IntersectionNodeLL {
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
    public static void insertNode(ListNode head, int value) {
        if(head == null) {
            head = new ListNode(value);
            return;
        }

        ListNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(value);
    }

    public static void printLL(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode getIntersectionNodeMapBF(ListNode head1, ListNode head2) {
        HashMap<ListNode, Integer> mp = new HashMap<>();
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        while(temp1 != null) {
            mp.put(temp1, 1);
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            if(mp.containsKey(temp2)) {
                return temp2;
            }
            temp2 = temp2.next;
        }

        return null;
    }

    public static int getDifference(ListNode head1, ListNode head2) {
        int n1 = 0; int n2 = 0;
        while(head1 != null) {
            n1++;
            head1 = head1.next;
        }

        while(head2 != null) {
            n2++;
            head2 = head2.next;
        }

        return n1-n2;
    }

    public static ListNode getIntersectionNodePointBA(ListNode head1, ListNode head2) {
        int d = getDifference(head1, head2);

        if(d < 0) {
            while(d != 0) {
                d++;
                head2 = head2.next;
            }
        } else {
            while(d != 0) {
                d--;
                head1 = head1.next;
            }
        }

        while(head1 != null) {
            if(head1 == head2) return head1;
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1;
    }

    public static ListNode getIntersectionNodeOpt(ListNode head1, ListNode head2) {
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        // while(temp1 != temp2) {
        //     temp1 = temp1.next;
        //     temp2 = temp2.next;


        //     if(temp1 == null) temp1 = head2;
        //     if(temp2 == null) temp2 = head1;
        // }
        while(temp1 != temp2) {
            temp1 = temp1 == null ? head2: temp1.next;
            temp2 = temp2 == null ? head1 : temp2.next;
        }

        return  temp1;
    }
    public static void main(String[] args) {
        ListNode head1 = new ListNode(3);
        insertNode(head1, 1);
        insertNode(head1, 4);
        insertNode(head1, 6);
        insertNode(head1, 2);

        ListNode head2 = new ListNode(1);
        insertNode(head2, 2);
        insertNode(head2, 4);
        insertNode(head2, 5);

        ListNode intersectionNode = head1.next.next;

        ListNode tail2 = head2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        tail2.next = intersectionNode;

        // printLL(head1);
        // printLL(head2);
        // ListNode intersectingNode = getIntersectionNodeMapBF(head1, head2);
        // System.out.println(intersectingNode.value);

        // ListNode intersectingNode = getIntersectionNodePointBA(head1, head2);
        // System.out.println(intersectingNode.value);

        ListNode intersectingNode = getIntersectionNodeOpt(head1, head2);
        System.out.println(intersectingNode.value);
    }
}
