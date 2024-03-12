//problem link
//https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/description/?envType=daily-question&envId=2024-03-12

import java.util.HashMap;

public class RemovZeroSum {
   public ListNode remmoveZeroSumSublits(ListNode head){
    ListNode newHead = new ListNode(0);
    newHead.next = head;
    HashMap<Integer, ListNode> map = new HashMap<>();
int sum =0;
map.put(sum,newHead);
ListNode temp = newHead;
while(temp!=null){
    sum+=temp.val;
    map.put(sum,temp);
    temp = temp.next;
}
sum =0;
temp = newHead;
while(temp!=null){
    sum+=temp.val;
    temp.next = map.get(sum).next;
    temp = temp.next;
   } 
   return newHead.next;
   }
}
