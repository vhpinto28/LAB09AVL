package Ejercicio3;

import avltree.AVLTree;
import avltree.ItemDuplicated;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmpresaProgram {
    public static void main(String[] args) {
        AVLTree<Integer> comercialTree = new AVLTree<>();
        AVLTree<Integer> produccionTree = new AVLTree<>();
        AVLTree<Integer> comunicacionesTree = new AVLTree<>();

        String fileName = "C:\\Users\\LENOVO\\Desktop\\EMPRESA.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                int numeroIdt = Integer.parseInt(fields[0].trim());
                int origen = Integer.parseInt(fields[1].trim());
                int destino = Integer.parseInt(fields[2].trim());

                // Almacenar en el árbol correspondiente según el departamento de origen
                AVLTree<Integer> origenTree = getTreeByDepartamento(origen, comercialTree, produccionTree, comunicacionesTree);
                try {
                    origenTree.insert(numeroIdt);
                } catch (ItemDuplicated e) {
                    System.out.println("Error: Elemento duplicado en el árbol de origen");
                    e.printStackTrace();
                }

                // Realizar el intercambio de registros según el campo destino
                AVLTree<Integer> destinoTree = getTreeByDepartamento(destino, comercialTree, produccionTree, comunicacionesTree);
                try {
                    destinoTree.insert(numeroIdt);
                } catch (ItemDuplicated e) {
                    System.out.println("Error: Elemento duplicado en el árbol de destino");
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //Obtener la altura de cada árbol
        System.out.println("Altura del árbol Comercial: " + comercialTree.height());
        System.out.println("Altura del árbol Producción: " + produccionTree.height());
        System.out.println("Altura del árbol Comunicaciones: " + comunicacionesTree.height());
    }

    private static AVLTree<Integer> getTreeByDepartamento(int departamento, AVLTree<Integer> comercialTree,
                                                          AVLTree<Integer> produccionTree,
                                                          AVLTree<Integer> comunicacionesTree) {
        if (departamento == 1) {
            return comercialTree;
        } else if (departamento == 2) {
            return produccionTree;
        } else if (departamento == 3) {
            return comunicacionesTree;
        } else {
            throw new IllegalArgumentException("Departamento inválido: " + departamento);
        }
    }
}
	