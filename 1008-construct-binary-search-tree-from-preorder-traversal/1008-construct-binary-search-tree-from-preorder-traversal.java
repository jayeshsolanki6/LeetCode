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
    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        return build(preorder, 0, len);
    }
    TreeNode build(int[] arr, int low, int high){
        if(low >= high) return null;
        TreeNode root = new TreeNode(arr[low]);
        int ind = low + 1;
        while(ind < high && arr[ind] < arr[low]) ind++;
        root.left = build(arr, low+1, ind);
        root.right = build(arr, ind, high);
        return root;
    }
}