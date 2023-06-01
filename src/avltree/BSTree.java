package avltree;

public class BSTree<E extends Comparable<E>> {
    protected class Node {
        protected E data;
        protected Node left;
        protected Node right;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    protected Node root;

    public BSTree() {
        this.root = null;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public void insert(E data) throws ItemDuplicated {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node node, E data) throws ItemDuplicated {
        if (node == null) {
            return new Node(data);
        }

        int compareResult = data.compareTo(node.data);

        if (compareResult < 0) {
            node.left = insertRecursive(node.left, data);
        } else if (compareResult > 0) {
            node.right = insertRecursive(node.right, data);
        } else {
            throw new ItemDuplicated("Item already exists in the tree");
        }

        return node;
    }

    public boolean search(E data) {
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(Node node, E data) {
        if (node == null) {
            return false;
        }

        int compareResult = data.compareTo(node.data);

        if (compareResult == 0) {
            return true;
        } else if (compareResult < 0) {
            return searchRecursive(node.left, data);
        } else {
            return searchRecursive(node.right, data);
        }
    }

    public void printInOrder() {
        printInOrderRecursive(root);
    }

    private void printInOrderRecursive(Node node) {
        if (node != null) {
            printInOrderRecursive(node.left);
            System.out.println(node.data);
            printInOrderRecursive(node.right);
        }
    }
}




