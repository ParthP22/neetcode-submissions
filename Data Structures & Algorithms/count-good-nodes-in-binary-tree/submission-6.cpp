/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:
    int goodNodes(TreeNode* root) {
        int ret = 0;
        queue<pair<TreeNode*, int>> q;
        q.push({root, -INT_MAX});

        while(!q.empty()){
            auto [node, maxval] = q.front();
            q.pop();

            if(node->val >= maxval){
                ret++;
            }

            int pathmax = max(node->val, maxval);
            if(node->left){
                q.push({node->left, pathmax});
            }
            if(node->right){
                q.push({node->right, pathmax});
            }
        }

        return ret;
    }
};
