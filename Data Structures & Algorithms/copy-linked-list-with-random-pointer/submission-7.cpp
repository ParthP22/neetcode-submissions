/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        unordered_map<Node*,Node*> old_to_new;
        old_to_new[NULL] = NULL;

        Node* curr = head;

        while(curr != NULL){
            old_to_new[curr] = new Node(curr->val);
            curr = curr->next;
        }

        curr = head;

        while(curr != NULL){
            Node* new_node = old_to_new[curr];
            new_node->next = old_to_new[curr->next];
            new_node->random = old_to_new[curr->random];

            curr = curr->next;
        }

        return old_to_new[head];
    }
};
