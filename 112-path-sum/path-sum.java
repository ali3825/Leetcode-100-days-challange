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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return bt(root,targetSum,0);
    }
    boolean bt(TreeNode root,int target,int sum){
        if(target==sum+root.val&&root.left==null&&root.right==null){
            return true;
        }
        if(root.left!=null&&bt(root.left,target,sum+root.val)){
            return true;
        }
        if(root.right!=null&&bt(root.right,target,sum+root.val)){
            return true;
        }
        return false;
    }
}