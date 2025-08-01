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
class BSTIterator {
    Stack<Integer> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        store(root);
    }
    
    public int next() {
        return stack.pop();
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void store(TreeNode root){
        if(root == null) return;
        store(root.right);
        stack.push(root.val);
        store(root.left);
        return;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */