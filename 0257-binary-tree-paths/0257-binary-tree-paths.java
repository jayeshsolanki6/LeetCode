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
    List<String> res;
    List<String> curr;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        curr = new ArrayList<>();

        find(root);
        return res;
    }
    void find(TreeNode root){
        curr.add(""+root.val);
        if(root.left == null && root.right == null){
            res.add(String.join("->", curr));
        }
        if(root.left != null){
            find(root.left);
        }
        if(root.right != null){
            find(root.right);
        }
        curr.remove(curr.size()-1);
    }
}