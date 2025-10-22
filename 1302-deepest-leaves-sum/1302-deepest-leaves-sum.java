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
    public int deepestLeavesSum(TreeNode root) {
        int max = depth(root);
        int[] sum = new int[1];
        traverse(root, 1, max, sum);
        return sum[0];
    }
    int depth(TreeNode root){
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left, right) + 1;
    }
    void traverse(TreeNode root, int level, int max, int[] sum){
        if(root == null) return;
        if(level == max){
            sum[0] += root.val;
            return;
        }
        traverse(root.left, level+1, max, sum);
        traverse(root.right, level+1, max, sum);
    }
}