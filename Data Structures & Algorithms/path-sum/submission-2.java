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
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        else {
            Stack<TreeNode> nodeStack = new Stack<>();
            Stack<Integer> sumStack = new Stack<>();
            nodeStack.push(root);
            sumStack.push(targetSum - root.val);

            while (!nodeStack.isEmpty()) {
                TreeNode current = nodeStack.pop();
                int currentSum = sumStack.pop();

                if (current.left == null && current.right == null && currentSum == 0) return true;
                else {
                    if (current.left != null) {
                        nodeStack.push(current.left);
                        sumStack.push(currentSum - current.left.val);
                    }
                    
                    if (current.right != null) {
                        nodeStack.push(current.right);
                        sumStack.push(currentSum - current.right.val);
                    }
                }
            }

            return false;
        }
    }
}