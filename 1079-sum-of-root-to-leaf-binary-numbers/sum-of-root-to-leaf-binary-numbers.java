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
    private int sum = 0;
    public int sumRootToLeaf(TreeNode root){
        dfs(0, root);
        return sum;
    }

    private void dfs(int val, TreeNode node) {
        int nexVal = (val << 1) | node.val;
        if(node.left == null && node.right == null) sum += nexVal;
        else{
            if(node.left != null) dfs(nexVal, node.left);
            if(node.right != null) dfs(nexVal, node.right);
        }
    }
}