class BinarySearchTree {

    static class Node {

        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    Node root;


    Node insert(Node root, int val) {

        if (root == null) {
            return new Node(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 4);

        tree.inorder(tree.root);
    }
}

/*
Time Complexity:
Insert Operation: O(h)
- Best/Average Case: O(log n) when the BST is balanced
- Worst Case: O(n) when the tree becomes skewed

Inorder Traversal: O(n) because every node is visited once.

Space Complexity:
Auxiliary Space: O(h) due to recursion stack
- Balanced Tree: O(log n)
- Skewed Tree: O(n)

Total Space for storing BST: O(n)
Where:
n = number of nodes
h = height of the tree
*/
