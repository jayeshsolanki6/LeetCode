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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> left = new LinkedList<>();
        left.add(root);

        Stack<TreeNode> right = new Stack<>();

        while(!left.isEmpty() || !right.isEmpty()){
            List<Integer> level = new ArrayList<>();
            while(!left.isEmpty()){
                TreeNode temp = left.remove();
                level.add(temp.val);
                if(temp.left != null) {right.push(temp.left);}
                if(temp.right != null) {right.push(temp.right);}
            }
            if(level.size()>0){
                list.add(level);
            }
            level = new ArrayList<>();
            while(!right.isEmpty()){
                TreeNode temp = right.pop();
                level.add(temp.val);
                if(temp.left != null) {left.add(temp.left);}
                if(temp.right != null) {left.add(temp.right);}
            }
            if(level.size()>0){
                list.add(level);
            }
        }
        return list;
    }
}