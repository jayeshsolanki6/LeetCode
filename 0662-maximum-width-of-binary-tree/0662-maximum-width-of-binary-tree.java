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
    class Pair {
        TreeNode node;
        long pos;
        Pair(TreeNode node, long pos){
            this.node = node;
            this.pos = pos;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 1));

        while(!q.isEmpty()){
            int n = q.size();
            long left = Long.MAX_VALUE;
            long right = Long.MIN_VALUE;
            for(int i = 0; i<n; i++){
                Pair p = q.remove();
                left = Math.min(left, p.pos);
                right = Math.max(right, p.pos);
                if(p.node.left != null){
                    q.add(new Pair(p.node.left, p.pos*2));
                }
                if(p.node.right != null){
                    q.add(new Pair(p.node.right, p.pos*2+1));
                }
            }
            res = Math.max(res, (int)(right-left+1));
        }
        return res;
    }
}