class SearchInBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode searchBST(TreeNode root, int val) {

        if (root == null || root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int searchValue = 2;

        TreeNode result = searchBST(root, searchValue);

        if (result != null) {
            System.out.println("Value found in BST: " + result.val);
        } else {
            System.out.println("Value not found in BST");
        }
    }
}

/*
Time Complexity: O(h)
- Best/Average Case: O(log n) when BST is balanced
- Worst Case: O(n) when BST becomes skewed

Space Complexity: O(h) due to recursion stack
- Balanced Tree: O(log n)
- Skewed Tree: O(n)

Where:
n = number of nodes
h = height of the tree
*/