//Question: Find the middle of a given linked list
//Question Link: https://leetcode.com/problems/middle-of-the-linked-list/?envType=daily-question&envId=2024-03-07

package LinkedList;
import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MiddleOfLL {
     public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        //Traverse the list with 2 pointers
        while(fast!=null && fast.next!=null){
            slow = slow.next; //move slow pointer by one
            fast = fast.next.next; //move fast pointer by two
        }

        //When fast pointer reaches the end, slow pointer will be at the middle
        return slow;
    }
}