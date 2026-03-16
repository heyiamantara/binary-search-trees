class InsertIntoBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
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

        TreeNode root = null;

        root = insertIntoBST(root, 4);
        root = insertIntoBST(root, 2);
        root = insertIntoBST(root, 7);
        root = insertIntoBST(root, 1);
        root = insertIntoBST(root, 3);

        System.out.print("BST Inorder Traversal: ");
        inorder(root);
    }
}

/*
Time Complexity: O(h)
Best/Average Case (Balanced BST): O(log n)
Worst Case (Skewed Tree): O(n)

Space Complexity: O(h) due to recursion stack
Balanced Tree: O(log n)
Worst Case: O(n)

Where:
n = number of nodes
h = height of the tree
*/