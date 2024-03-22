//Question: Given the head of a singly linked list, return true if it is a palindrome.
//link: https://leetcode.com/problems/palindrome-linked-list/
package LinkedList;

public class PallindromLL {
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

    public boolean isPalindrome(ListNode head) {
        ListNode temp=head;
        StringBuilder sb=new StringBuilder("");
        while(temp!=null){
            sb.append(temp.val);
            temp=temp.next;
        }
        return checkPalindrome(sb.toString());
    }
    public boolean checkPalindrome(String str) {
        // Remove all non-alphanumeric characters and convert to lowercase
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Compare characters from start and end simultaneously
        int start = 0;
        int end = cleanStr.length() - 1;
        
        while (start < end) {
            if (cleanStr.charAt(start) != cleanStr.charAt(end)) {
                return false; // Not a palindrome
            }
            start++;
            end--;
        }
        return true; // Palindrome
    }

}
