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
            return Integer.MIN_VALUE;
        }

        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    public static int findMin(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    public static void main(String[] args) {

        Node root = new Node(7);
        root.left = new Node(8);
        root.right = new Node(6);
        root.left.left = new Node(3);

        System.out.println("Minimum value in Tree: " + findMin(root));
        System.out.println("Maximum value in Tree: " + findMax(root));
    }
}

/*
Time Complexity: O(n)
- Each node is visited once.

Space Complexity: O(h)
- Due to recursion stack.
- Balanced tree: O(log n)
- Worst case (skewed tree): O(n)

Where:
n = number of nodes
h = height of the tree
*/