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
    long maxSum = 0;
    public int maxProduct(TreeNode root) {
        TreeNode temp = root;
        long totalSum = sum(temp);
        temp = root;
        check(temp, totalSum);
        return (int)(maxSum % 1000000007); 
    }
    long sum(TreeNode root){
        if(root == null) return 0;
        long left = sum(root.left);
        long right = sum(root.right);
        return root.val + left + right;
    }
    long check(TreeNode root, long total){
        if(root == null) return 0;
        long left = check(root.left, total);
        long right = check(root.right, total);
        long stsum = root.val + left + right;
        maxSum = Math.max(maxSum, stsum * (total-stsum));
        return stsum;
    }
}