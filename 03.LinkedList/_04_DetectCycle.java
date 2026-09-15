import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _04_DetectCycle {
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

    public static void printLL(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Boolean detectCycleBFSet(ListNode head) {
        ListNode temp = head;
        Set<ListNode> st = new HashSet<>();
        while (temp != null) {
            if(st.contains(temp)) {
                return true;
            }
            st.add(temp);
            temp = temp.next;
        }
        return false;
    }

    public static Boolean detectCycleMap(ListNode head) {
        ListNode temp = head;
        HashMap<ListNode, Integer> mp = new HashMap<>();
        while(temp != null) {
            if(mp.containsKey(temp)) {
                return true;
            }
            mp.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }

    public static Boolean detectCycleOpt(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        fifth.next = third;

        // Boolean resultBFSet = detectCycleBFSet(head);
        // System.out.println("BF Set: " + resultBFSet);

        Boolean resultBFMap = detectCycleMap(head);
        System.out.println("BF Set: " + resultBFMap);
    }
}

// BF:

// Set:
// TC: O(n)
// SC: O(n)

// Map:
// TC: O(n)
// SC: O(n)

// Opt:
// TC: O(n)
// SC: O(1)