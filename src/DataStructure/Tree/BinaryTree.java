/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Tree;
import DataStructure.Node.NodeTree;
/**
 *
 * @author danx_
 */
public class BinaryTree<T> {
    NodeTree root;
    int elements;
    
    public BinaryTree() {
        this.root = null;
        this.elements = 0;
    }
    public boolean eTree() {
        return this.root == null;
    }
    public void insertNode(T data, NodeTree raiz) {
        NodeTree nodo = new NodeTree(data);
        if (eTree()) {
            this.root = nodo;
            elements++;
        } else {
            if ((int) nodo.data >= (int) raiz.data) {
                if (raiz.left == null) {
                    raiz.left = nodo;
                    elements++;
                } else {
                    insertNode(data, raiz.left);
                }
            } else {
                if (raiz.right == null) {
                    raiz.right = nodo;
                    elements++;
                } else {
                    insertNode(data, raiz.right);
                }
            }
        }
    }
    public boolean raices(NodeTree n, int dato){
        if (n==null) {
            return false;
        }
        if (n.right==null && n.left==null) {
            return false;
        }
        if (n.left==null) {
            return (int) n.right.data != dato;
        }
        if (n.right==null) {
            return (int) n.left.data != dato;
        }
        return (int) n.left.data != dato && (int) n.right.data != dato;
    }
    public boolean comparar(NodeTree n, int dato){
        if (n==null) {
            return false;
        }
        return n.data.equals(dato);
    }
    public void eNode(int dato, NodeTree raiz, int i) {
        if (searchNode(dato, raiz)) {
            while (raices (raiz, dato)) {
                if (dato > (int) raiz.data) {
                    raiz = raiz.left;
                }else{
                if (dato < (int) raiz.data) {
                    raiz = raiz.right;
                }
                }
            }
            if (comparar(raiz.left, dato)) {
                if (hoja(raiz.left)) {
                    raiz.left = null;
                }
                if (Hijos(raiz.left)) {
                    NodeTree aux = regresarSustituto(raiz.left);
                    eNode((int)aux.data, raiz.left,0);
                    raiz.left.data = aux.data; 
                }
            }
            if (comparar(raiz.right, dato)) {
                if (hoja(raiz.right)) {
                    raiz.right = null;
                }
                if (Hijos(raiz.right)) {// tiene subarbol
                   NodeTree aux = regresarSustituto(raiz.right);
                    eNode((int)aux.data, raiz.right,0);
                    raiz.right.data = aux.data;
                }
            }
            elements=elements+i;
        } else {
            System.out.println("No se encontró el dato en el árbol");
        }
    }
    public int Height(NodeTree n){
        if (n == null) {
            return -1;
        }else{
            return 1+Math.max(Height(n.left), Height(n.right));
        }
    }
   
    public boolean hoja(NodeTree n) {
        if (n==null) {
            return false;
        }
        return n.left == null && n.right == null;
    }
    public boolean Hijos(NodeTree n) {
        if (n==null) {
            return false;
        }
        if (n.left==null && n.right==null) {
            return false;
        }
        if (n.left==null && n.right!=null) {
            return true;
        }
        if (n.right==null && n.left!=null) {
            return true;
        }
        return n.left != null || n.right != null;
    }
    public NodeTree regresarSustituto(NodeTree n) {
        if (n.left == null) {
            return n.right;
        } else {
            if (n.left.right == null) {
                return n.left;
            } else {
                n = n.left.right;
                while (n.right != null) {
                    n = n.right;
                }
                return n;
            }
        }
    }
    public boolean searchNode(int dato, NodeTree raiz) {
        if (raiz == null) {
            return false;
        }
        if ((int) raiz.data == (dato)) {
            return true;
        }
        if ((int) raiz.data < dato) {
            return searchNode(dato, raiz.left);
        }
        if ((int) raiz.data > dato) {
            return searchNode(dato, raiz.right);
        }
        return searchNode(dato, raiz);

    }
    public void printInOrder(NodeTree raiz, boolean der, boolean izq) {
        while (der == false && raiz.right != null) {
            printInOrder(raiz.right, der, false);
            der = true;
        }
        System.out.print("|" + raiz.data + "| ");
        while (raiz.left != null && izq == false) {
            printInOrder(raiz.left, false, izq);
            izq = true;
        }
    }
    public void printPostOrder(NodeTree raiz, boolean der, boolean izq) {
        while (der == false && raiz.right != null) {
            printPostOrder(raiz.right, der, false);
            der = true;
        }
        while (raiz.left != null && izq == false) {
            printPostOrder(raiz.left, false, izq);
            izq = true;
        }
        System.out.print("|" + raiz.data + "| ");
    }
    public void printPreOrder(NodeTree raiz, boolean der, boolean izq) {
        System.out.print("|" + raiz.data + "| ");
        while (der == false && raiz.right != null) {
            printPreOrder(raiz.right, der, false);
            der = true;
        }
        while (raiz.left != null && izq == false) {
            printPreOrder(raiz.left, false, izq);
            izq = true;
        }
    }
}
