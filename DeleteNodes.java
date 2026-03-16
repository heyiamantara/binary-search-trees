class DeleteNodeBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public static TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } 
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } 
        else {

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    public static TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        System.out.print("Before Deletion: ");
        inorder(root);

        root = deleteNode(root, 3);

        System.out.print("\nAfter Deletion: ");
        inorder(root);
    }
}

/*
Deletion Cases in BST:
1. Node is a leaf → simply remove it
2. Node has one child → replace node with its child
3. Node has two children → replace with inorder successor (min of right subtree)

Time Complexity: O(h)
Best/Average Case (Balanced BST): O(log n)
Worst Case (Skewed Tree): O(n)

Space Complexity: O(h) due to recursion
Where:
n = number of nodes
h = height of tree
*/