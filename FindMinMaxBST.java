class FindMinMaxBST {

    static class Node {
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public static int findMax(Node root) {
        if (root == null) {
            return -1;
        }

        while (root.right != null) {
            root = root.right;
        }

        return root.data;
    }

    public static int findMin(Node root) {
        if (root == null) {
            return -1;
        }

        while (root.left != null) {
            root = root.left;
        }

        return root.data;
    }

    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);

        System.out.println("Minimum value in BST: " + findMin(root));
        System.out.println("Maximum value in BST: " + findMax(root));
    }
}

/*
Time Complexity:
findMin: O(h)
findMax: O(h)

Best/Average Case (Balanced BST): O(log n)
Worst Case (Skewed BST): O(n)

Space Complexity: O(1)
Iterative approach uses no recursion stack.

Where:
n = number of nodes
h = height of the tree
*/