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
    public int diameterOfBinaryTree(TreeNode root) {
        // Base Case: Leaf = 0 distance
        if (root == null) return 0;
        else {
            int[] diameter = new int[1];
            diameterCheck(root, diameter);
            return diameter[0];
        }
    }
    private int diameterCheck(TreeNode root, int[] maxDiameter) {
        if (root == null) return 0;
        else {
            int left = diameterCheck(root.left, maxDiameter);
            int right = diameterCheck(root.right, maxDiameter);
            maxDiameter[0] = Math.max(maxDiameter[0], left + right);

            return 1 + Math.max(left, right);
        }
    }
}
