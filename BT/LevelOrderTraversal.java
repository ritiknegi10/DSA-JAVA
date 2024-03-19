//Question: https://leetcode.com/problems/binary-tree-level-order-traversal/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class LevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        List<List<Integer>> ans=new ArrayList<>();
        
        if(root==null)
            return ans;
        
        q.add(root);
        
        while(!q.isEmpty()){
            int levelSize=q.size();
            List<Integer> levelWise=new ArrayList<>();
            while(levelSize>0){
                if(q.peek().left!=null)
                    q.add(q.peek().left);
                if(q.peek().right!=null)
                    q.add(q.peek().right);
                
                levelWise.add(q.remove().val);
                
                levelSize--;
            }
            
            ans.add(levelWise);
            
        }
        
        return ans;
    }

}
