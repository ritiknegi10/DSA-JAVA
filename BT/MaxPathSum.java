//Question: https://leetcode.com/problems/binary-tree-maximum-path-sum/
import javax.swing.tree.TreeNode;

public class MaxPathSum {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

    int max = Integer.MIN_VALUE;
    public int maxPath(TreeNode root){
if(root==null) return 0;
        int value = root.val;
        int left_sum = Math.max(maxPath(root.left),0);
                int right_sum = Math.max(maxPath(root.right),0);
                max = Math.max(max,left_sum +right_sum +value);
                return Math.max(left_sum,right_sum)+value;

    }
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }
}
