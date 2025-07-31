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
    int count = 0;
    int res, num;
    public int kthSmallest(TreeNode root, int k) {
        num = k;
        traverse(root);
        return res;
    }
    void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.left);
        count++;
        if(count == num){
            res = root.val;
            return;
        }
        traverse(root.right);
    }
}