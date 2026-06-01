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
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            Queue<Integer> sumQueue = new LinkedList<>();
            nodeQueue.add(root);
            sumQueue.add(targetSum - root.val);

            while (!nodeQueue.isEmpty()) {
                TreeNode current = nodeQueue.poll();
                int currentSum = sumQueue.poll();
                
                if (current.left == null && current.right == null && currentSum == 0) return true;
                else {
                    if (current.left != null) {
                        nodeQueue.add(current.left);
                        sumQueue.add(currentSum - current.left.val);
                    }
                    
                    if (current.right != null) {
                        nodeQueue.add(current.right);
                        sumQueue.add(currentSum - current.right.val);
                    }
                }
            }

            return false;
        }
    }
}