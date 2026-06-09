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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<TreeNode> parent = new HashSet<>();
        Set<TreeNode> child = new HashSet<>();
        HashMap<Integer, TreeNode> tree = new HashMap<>();

        for(int[] disc : descriptions){
            int p = disc[0];
            int c = disc[1];
            int isLeft = disc[2];

            TreeNode parNode = getParNode(tree, p);
            TreeNode childNode = getChildNode(tree, c);
            if(isLeft == 1){
                parNode.left = childNode;
            } else{
                parNode.right = childNode;
            }
            parent.add(parNode);
            child.add(childNode);
        }
        // System.out.println(parent.size());
        for(TreeNode ch : child){
            parent.remove(ch);
        }
        for(TreeNode par : parent){
            return par;
        }
        return null;
    }

    TreeNode getParNode(HashMap<Integer, TreeNode> tree, int p){
        if(tree.containsKey(p)) return tree.get(p);
        TreeNode par = new TreeNode(p);
        tree.put(p, par);
        return par;
    }
    TreeNode getChildNode(HashMap<Integer, TreeNode> tree, int c){
        if(tree.containsKey(c)) return tree.get(c);
        TreeNode child = new TreeNode(c);
        tree.put(c, child);
        return child;
    }
}