package DataStructures.BinaryTree;

/**
 * A class representing a Binary Search Tree (BST).
 * Provides insertion and traversal methods (pre-order, in-order, post-order).
 */
public class BinaryTree {

    TreeNode root; // Root of the binary tree

    /**
     * Public method to insert data into the BST.
     * @param data the value to insert
     */
    public void insert(int data) {
        root = insertRec(root, data);
    }

    /**
     * Recursive method to insert data into the tree based on BST rules.
     * If the current node is null, create a new node.
     * If the data is smaller, go left; if larger, go right.
     * @param root current subtree root
     * @param data value to insert
     * @return the updated root node of the subtree
     */
    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else if (data < root.getData()) {
            root.setLeftNode(insertRec(root.getLeftNode(), data));
        } else if (data > root.getData()) {
            root.setRightNode(insertRec(root.getRightNode(), data));
        }

        return root;
    }

    /**
     * Public method to print the tree in pre-order traversal.
     * Pre-order: Root -> Left -> Right
     */
    public void preOrder() {
        orderRec(root, 1);
        System.out.println();
    }

    /**
     * Public method to print the tree in in-order traversal.
     * In-order: Left -> Root -> Right
     */
    public void inOrder() {
        orderRec(root, 2);
        System.out.println();
    }

    /**
     * Public method to print the tree in post-order traversal.
     * Post-order: Left -> Right -> Root
     */
    public void postOrder() {
        orderRec(root, 3);
        System.out.println();
    }

    /**
     * Recursive traversal method based on the given type.
     * 1 - Pre-order, 2 - In-order, 3 - Post-order
     * @param root the current node
     * @param type the type of traversal
     */
    private void orderRec(TreeNode root, int type) {
        if (root != null) {

            if (type == 1) // Pre-order
                System.out.print(root.getData() + " ");

            orderRec(root.getLeftNode(), type);

            if (type == 2) // In-order
                System.out.print(root.getData() + " ");

            orderRec(root.getRightNode(), type);

            if (type == 3) // Post-order
                System.out.print(root.getData() + " ");
        }
    }
}

/**
 * A simple TreeNode class for binary trees.
 * Contains integer data and references to left and right children.
 */
class TreeNode {
    private int data;
    private TreeNode leftNode;
    private TreeNode rightNode;

    /**
     * Constructor to create a TreeNode with a specific value.
     * @param data the value to store in the node
     */
    public TreeNode(int data) {
        this.data = data;
        leftNode = null;
        rightNode = null;
    }

    // Getter and setter methods for data and child nodes

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
