//Question Link
//https://www.geeksforgeeks.org/problems/diagonal-sum-in-binary-tree/1
import java.util.ArrayList;
import java.util.Stack;

import org.w3c.dom.Node;

public class DiagonalSum {
    public static ArrayList <Integer> diagonalSum(Node root)  {
        // code here.
        Stack<Node> leftNodes = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        leftNodes.add(root);
        
        while(!leftNodes.isEmpty()) {
            Stack<Node> tempNodes = new Stack<>();
            int sum = 0;
            while(!leftNodes.isEmpty()) {
                Node temp = leftNodes.pop();
                sum += helper(temp, tempNodes);
            }
            ans.add(sum);
            leftNodes = tempNodes;
        }
        
        return ans;
    }
    
    public static int helper(Node node, Stack<Node> leftNodes) {
        if(node == null) return 0;
        
        if(node.left != null) leftNodes.push(node.left);
        int sum = node.data + helper(node.right, leftNodes);
        
        return sum;
    }
}
