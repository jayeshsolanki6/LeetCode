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
    int res;
    public int averageOfSubtree(TreeNode root) {
        res = 0;
        find(root);
        return res;
    }
    int[] find(TreeNode root){
        if(root == null) return new int[]{0, 0};

        int[] left = find(root.left);
        int[] right = find(root.right);

        int[] curr = new int[]{
            left[0] + right[0] + root.val, 
            left[1] + right[1] + 1
        };
        if(curr[0]/curr[1] == root.val) res++;
        return curr;
    }
}