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
    public int goodNodes(TreeNode root) {
        return 1 + dfs(root.left,root.val) + dfs(root.right,root.val);
    }

    public int dfs(TreeNode root, int maxNum){
        if(root == null){
            return 0;
        }

        int valid = 0;

        int max = Math.max(maxNum,root.val);

        if(root.val >= max){
            valid++;
        }

        return valid + dfs(root.left,max) + dfs(root.right,max);
    }
}
