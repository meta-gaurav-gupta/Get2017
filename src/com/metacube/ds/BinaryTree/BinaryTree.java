package com.metacube.ds.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Gaurav
 * @param <T> the type of elements held in this collection
 */
public class BinaryTree<T> {
    /** 
     * Root element of tree. 
     */
    private Node<T> root;

    /** 
     * Queue which store the parent Nodes
     */ 
    private Queue<Node<T>> parentNodes;


    /**
     * Instantiates a new binary tree.
     */
    public BinaryTree(){
        root = null;
        this.parentNodes = new LinkedList<>();
    }

    /**
     * Insert data into tree
     *
     * @param data the data to be inserted into tree
     */
    private void insert(T data) {
        try {
            Node<T> newNode = new Node<>(data);
            if (this.root == null) {
                this.root = newNode;
                parentNodes.add(this.root);
            } else {
                Node<T> currentNode = parentNodes.peek();
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(newNode);
                    parentNodes.add(currentNode.getLeft());
                } else {
                    currentNode.setRight(newNode);
                    parentNodes.add(currentNode.getRight());
                    parentNodes.remove();
                }
            }
        }catch(Exception e) {
            System.out.println("Error Caught while adding the element " + e.getMessage());
        }
    }

    /**
     * preOrder traversal.
     *
     * @param root the root node
     */
    private void printPreOrder(Node<T> root){
        if(root==null){
            return ;
        }
        
        System.out.print(root.getData() + " ");
        printPreOrder(root.getLeft());
        printPreOrder(root.getRight());
    }

    /**
     * post order traversal.
     *
     * @param root the root node
     */
    private void printPostOrder(Node<T> root){

        if(root==null){
            return ;
        }
        printPostOrder(root.getLeft());
        printPostOrder(root.getRight());
        System.out.print(root.getData() + " ");

    }

    /**
     * in order traversal.
     *
     * @param root the root node
     */
    private void printInOrder(Node<T> root){
        if(root == null){
            return ;
        }
        printInOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        printInOrder(root.getRight());
    }
    /**
     * call insert Node.
     *
     * @param data the data
     */
    public void insertNode(T data){
        insert(data);
    }

    /**
     * Gets the in order.
     *
     */
    public void inOrder(){
        if(this.root == null){
            System.out.println("Tree is empty!!");
        } else {
            printInOrder(this.root);
        }
    }

    /**
     * Gets the pre order.
     *
     */
    public void preOrder(){
        if(this.root == null){
            System.out.println("Tree is empty!!");
        } else {
            printPreOrder(this.root);
        }
    }

    /**
     * Gets the post order.
     *
     */
    public void postOrder(){
        if(this.root == null){
            System.out.println("Tree is empty!!");
        } else {
            printPostOrder(this.root);
        }
    }

    /**
     * Check if two trees are mirror
     *
     * @param tree second tree
     * @return true, if the second tree is mirror of current tree
     */
    public boolean mirror(BinaryTree<T> tree){
        boolean result = false;
        try {
            result = mirrorUtils(this.getRoot(), tree.getRoot());
        }catch(Exception e) {
            System.out.println("Error Caught checking the mirror " + e.getMessage());
        }
        /*return result*/
        return result;
    }
     
    /**
     * Mirror Utility function
     * @param root1 Root node of first tree
     * @param root2 Root node of second tree
     * @return boolean true if the second tree is mirror of first tree
     */
    private boolean mirrorUtils(Node root1, Node root2){
        boolean result = false;
        if (root1 == null && root2 == null) {
            result = true;
        } else if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) { 
            /** 
             * if any node doesn't have corresponding node in the another tree, return false
             */
            result = false;
        } else if(!root1.getData().equals(root2.getData())){
            result = false;
        } else {
            // check if left node in one tree is the right node in another tree, and
            // vice versa
            result = mirrorUtils(root1.getLeft(), root2.getRight()) && mirrorUtils(root1.getRight(), root2.getLeft());
        }
        
        return result;
        
    }

    /**
     * Gets the root node.
     *
     * @return root node
     */
    public Node<T> getRoot(){
        return this.root;
    }
    
    /**
     * Clear the tree
     */
    public void clear(){
        root = null;
        this.parentNodes.clear();
    }
}
