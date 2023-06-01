package avltree;

public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();

        try {
            // Caso 1: Rotación simple a la derecha (RSR)
            avlTree.insert(10);
            avlTree.insert(5);
            avlTree.insert(15);
            avlTree.insert(3);
            avlTree.insert(8);

            // Caso 2: Rotación simple a la izquierda (RSL)
            avlTree.insert(20);
            avlTree.insert(25);
            avlTree.insert(15);
            avlTree.insert(30);

            // Caso 3: Rotación doble a la derecha (RDR)
            avlTree.insert(10);
            avlTree.insert(5);
            avlTree.insert(15);
            avlTree.insert(13);
            avlTree.insert(17);

            // Caso 4: Rotación doble a la izquierda (RDL)
            avlTree.insert(10);
            avlTree.insert(15);
            avlTree.insert(5);
            avlTree.insert(7);
            avlTree.insert(3);

            // Caso 5: Otra rotación simple a la derecha (RSR)
            avlTree.insert(10);
            avlTree.insert(15);
            avlTree.insert(20);
            avlTree.insert(12);
            avlTree.insert(17);

            // Caso 6: Otra rotación simple a la izquierda (RSL)
            avlTree.insert(30);
            avlTree.insert(25);
            avlTree.insert(20);
            avlTree.insert(27);
            avlTree.insert(23);

            // Caso 7: Otra rotación doble a la derecha (RDR)
            avlTree.insert(10);
            avlTree.insert(5);
            avlTree.insert(20);
            avlTree.insert(15);
            avlTree.insert(17);

            // Caso 8: Otra rotación doble a la izquierda (RDL)
            avlTree.insert(30);
            avlTree.insert(35);
            avlTree.insert(20);
            avlTree.insert(25);
            avlTree.insert(23);

            // Caso 9: Prueba de búsqueda en un árbol AVL
            int searchKey = 15;
            if (avlTree.search(searchKey)) {
                System.out.println("Elemento " + searchKey + " encontrado en el árbol AVL.");
            } else {
                System.out.println("Elemento " + searchKey + " no encontrado en el árbol AVL.");
            }

            // Caso 10: Prueba de altura de un árbol AVL
            int height = avlTree.height();
            System.out.println("Altura del árbol AVL: " + height);

            // Caso 11: Prueba de búsqueda en un árbol BST
            BSTree<Integer> bstTree = new BSTree<>();
            bstTree.insert(10);
            bstTree.insert(5);
            bstTree.insert(15);
            searchKey = 15;
            if (bstTree.search(searchKey)) {
                System.out.println("Elemento " + searchKey + " encontrado en el árbol BST.");
            } else {
                System.out.println("Elemento " + searchKey + " no encontrado en el árbol BST.");
            }

            // Caso 12: Prueba de altura de un árbol BST
            height = bstTree.height();
            System.out.println("Altura del árbol BST: " + height);
        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


