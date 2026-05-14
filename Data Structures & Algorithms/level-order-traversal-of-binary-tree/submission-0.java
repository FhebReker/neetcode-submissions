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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Initialize list of levels, queue, and current level list
        List<List<Integer>> listPerLevel = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();

        // Return empty list if null root
        if (root == null) return listPerLevel;

        
        // Add root, then loop until the queue is empty
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            // Initialize current level's list
            List<Integer> currentLevelList = new ArrayList<>();
            int currentLevelSize = nodeQueue.size();
            
            // Loop through the current level to add nodes to the current level list
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode current = nodeQueue.poll();
                currentLevelList.add(current.val);

                // Add child nodes if they're non-null
                if (current.left != null) nodeQueue.offer(current.left);
                if (current.right != null) nodeQueue.offer(current.right);
            }

            // Add the list of the current level
            listPerLevel.add(currentLevelList);
        }

        // Return the list of level lists
        return listPerLevel;
    }
}
