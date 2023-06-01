
package avltree;

public class AVLTree<E extends Comparable<E>> {

    protected AVLNode root;

    public void insert(E data) throws ItemDuplicated {
        this.root = insertRecursive(root, data);
    }

    private AVLNode insertRecursive(AVLNode node, E data) throws ItemDuplicated {
        if (node == null) {
            return new AVLNode(data);
        }

        int compareResult = data.compareTo(node.data);

        if (compareResult < 0) {
            node.left = insertRecursive(node.left, data);
            node = balanceToLeft(node);
        } else if (compareResult > 0) {
            node.right = insertRecursive(node.right, data);
            node = balanceToRight(node);
        } else {
            throw new ItemDuplicated("Elemento duplicado: " + data);
        }

        updateHeight(node);

        return node;
    }

    public boolean search(E data) {
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(AVLNode node, E data) {
        if (node == null) {
            return false;
        }

        int compareResult = data.compareTo(node.data);

        if (compareResult < 0) {
            return searchRecursive(node.left, data);
        } else if (compareResult > 0) {
            return searchRecursive(node.right, data);
        } else {
            return true;
        }
    }

    public int height() {
        return getHeight(root);
    }

    private int getHeight(AVLNode node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void remove(E data) {
        this.root = removeRecursive(root, data);
    }

    private AVLNode removeRecursive(AVLNode node, E data) {
        if (node == null) {
            return null;
        }

        int compareResult = data.compareTo(node.data);

        if (compareResult < 0) {
            node.left = removeRecursive(node.left, data);
            node = balanceToLeft(node);
        } else if (compareResult > 0) {
            node.right = removeRecursive(node.right, data);
            node = balanceToRight(node);
        } else {
            // Encontramos el nodo a eliminar

            // Caso 1: Nodo sin hijos o con un solo hijo
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            }
            // Caso 2: Nodo con dos hijos
            else {
                AVLNode successor = findMin(node.right);
                node.data = successor.data;
                node.right = removeRecursive(node.right, node.data);
                node = balanceToRight(node);
            }
        }

        if (node != null) {
            updateHeight(node);
        }

        return node;
    }

    private AVLNode findMin(AVLNode node) {
        if (node.left != null) {
            return findMin(node.left);
        }
        return node;
    }

    private AVLNode balanceToLeft(AVLNode node) {
        if (node == null) {
            return null;
        }

        if (getHeight(node.left) - getHeight(node.right) == 2) {
            if (getHeight(node.left.left) >= getHeight(node.left.right)) {
                node = rotateRight(node);
            } else {
                node = doubleRotateLeftRight(node);
            }
        }

        return node;
    }

    private AVLNode balanceToRight(AVLNode node) {
        if (node == null) {
            return null;
        }

        if (getHeight(node.right) - getHeight(node.left) == 2) {
            if (getHeight(node.right.right) >= getHeight(node.right.left)) {
                node = rotateLeft(node);
            } else {
                node = doubleRotateRightLeft(node);
            }
        }

        return node;
    }

    private AVLNode rotateLeft(AVLNode node) {
        AVLNode newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;

        updateHeight(node);
        updateHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode node) {
        AVLNode newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;

        updateHeight(node);
        updateHeight(newRoot);

        return newRoot;
    }

    private AVLNode doubleRotateLeftRight(AVLNode node) {
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    private AVLNode doubleRotateRightLeft(AVLNode node) {
        node.right = rotateRight(node.right);
        return rotateLeft(node);
    }

    private void updateHeight(AVLNode node) {
        if (node != null) {
            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
    }

    protected class AVLNode {
        protected E data;
        protected AVLNode left;
        protected AVLNode right;
        protected int height;

        public AVLNode(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 0;
        }
    }
}





	















