// problem link

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/?envType=daily-question&envId=2024-03-03
class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNthElement {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;
        
        // traversing linked list to find length
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        
        // reset temp to head of list
        temp = head;
        ListNode prev = null;
        int pos = len - n;

        if (pos == 0) return head.next;

        // Traverse the list again to reach the node just before the one to be removed
        for (int i = 0; i < pos; i++) {
            prev = temp;
            temp = temp.next;
        }

        // update pointer
        prev.next = temp.next;

        // delete the node
        temp = null;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthElement solution = new RemoveNthElement();

        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2; // Remove the 2nd node from the end of list

        ListNode result = solution.removeNthFromEnd(head, n);

        // Print the resulting list: 1 -> 2 -> 3 -> 5
        ListNode temp = result;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
