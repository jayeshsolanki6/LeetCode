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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val == key) helper(root);
        TreeNode temp = root;
        while(temp != null){
            if(temp.left != null && temp.left.val == key){
                temp.left = helper(temp.left);
            }
            if(temp.right != null && temp.right.val == key){
                temp.right = helper(temp.right);
            }
            if(key < temp.val) temp = temp.left;
            else temp = temp.right;
        }
        return root;
    }
    TreeNode helper(TreeNode root){
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;
        TreeNode lastRight = find(root.left);
        lastRight.right = root.right;
        return root.left; 
    }
    TreeNode find(TreeNode root){
        if(root.right == null) return root;
        return find(root.right);
    }
    
}