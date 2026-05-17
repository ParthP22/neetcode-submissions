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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        Deque<TreeNode> dq = new ArrayDeque<>();

        List<Integer> list = new ArrayList<>();

        dq.offerLast(root);

        while(!dq.isEmpty()){
            int size = dq.size();
            list.add(dq.peekLast().val);
            for(int i = 0; i < size; i++){
                TreeNode curr = dq.pollFirst();
                if(curr.left != null){
                    dq.offerLast(curr.left);
                }
                if(curr.right != null){
                    dq.offerLast(curr.right);
                }
            }
        }

        return list;
    }
}
