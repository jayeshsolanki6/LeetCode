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
    int min = Integer.MAX_VALUE;
    int left = -(int)1e9;
    public int getMinimumDifference(TreeNode root) {
        find(root);
        return min;
    }
    void find(TreeNode root){
        if(root == null) return;
        find(root.left);
        min = Math.min(min, root.val-left);
        left = root.val;
        find(root.right);
    }

}