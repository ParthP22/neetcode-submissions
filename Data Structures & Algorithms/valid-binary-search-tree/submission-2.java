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
    public boolean isValidBST(TreeNode root) {
        return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean valid(TreeNode curr, long left, long right){
        if(curr == null){
            return true;
        }

        if(curr.val >= right || curr.val <= left){
            return false;
        }

        return valid(curr.left, left, curr.val) && valid(curr.right, curr.val, right);
    }   
}
