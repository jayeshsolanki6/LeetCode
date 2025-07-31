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
    Stack<Integer> stack = new Stack<>();
    int num;
    public int kthSmallest(TreeNode root, int k) {
        num = k;
        traverse(root);
        return stack.pop();
    }
    void traverse(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            stack.push(root.val);
            return;
        }
        traverse(root.left);
        if(stack.size() == num) return;
        stack.push(root.val);
        if(stack.size() == num) return;
        traverse(root.right);
        if(stack.size() == num) return;
    }
}