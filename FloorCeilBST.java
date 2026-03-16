class FloorCeilBST {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static int floor(Node root, int key) {
        int floor = -1;

        while (root != null) {

            if (root.data == key) {
                return root.data;
            }

            if (root.data > key) {
                root = root.left;
            } 
            else {
                floor = root.data;
                root = root.right;
            }
        }

        return floor;
    }

    public static int ceil(Node root, int key) {
        int ceil = -1;

        while (root != null) {

            if (root.data == key) {
                return root.data;
            }

            if (root.data < key) {
                root = root.right;
            } 
            else {
                ceil = root.data;
                root = root.left;
            }
        }

        return ceil;
    }

    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);

        int key = 5;

        System.out.println("Floor of " + key + " = " + floor(root, key));
        System.out.println("Ceil of " + key + " = " + ceil(root, key));
    }
}

/*
Floor = greatest value <= key
Ceil  = smallest value >= key

Time Complexity: O(h)
Best/Average (Balanced BST): O(log n)
Worst Case (Skewed Tree): O(n)

Space Complexity: O(1)
Iterative approach uses constant space.

Where:
n = number of nodes
h = height of tree
*/