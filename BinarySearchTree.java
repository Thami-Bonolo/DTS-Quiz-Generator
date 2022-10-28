/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sammy
 */

import java.util.*;
public class BinarySearchTree{ 
  
    /* Class containing left and right child of current node and key value*/
    class Node { 
        int key; 
        Node left, right; 
  
        public Node(int item) { 
            key = item; 
            left = right = null; 
        } 
    } 
    ArrayList<Integer> pre = new ArrayList<Integer>(); 
    ArrayList<Integer> post = new ArrayList<Integer>();  
    ArrayList<Integer> Level = new ArrayList<Integer>();  
    ArrayList<Integer> in = new ArrayList<Integer>();     // Root of BST 
    Node root; 
  
    // Constructor 
    BinarySearchTree() {  
        root = null;  
    } 
  
    public int getRoot(){
        return root.key;
    }

    // This method mainly calls insertRec() 
    void insert(int key) { 
       root = insertRec(root, key); 
    } 
      
    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) { 
  
        /* If the tree is empty, return a new node */
        if (root == null) { 
            root = new Node(key); 
            return root;  
        } 
    
  
        /* Otherwise, recur down the tree */
        if (key < root.key) 
            root.left = insertRec(root.left, key); 
        else if (key > root.key) 
            root.right = insertRec(root.right, key); 
  
        /* return the (unchanged) node pointer */
        return root; 
    } 
  
    // This method mainly calls InorderRec() 
    void inorder()  { 
       inorderRec(root); 
    } 
  
    // A utility function to do inorder traversal of BST 
    void inorderRec(Node root) { 
        if (root != null) { 
            inorderRec(root.left); 
           // System.out.println(root.key); 
            in.add(root.key);
            inorderRec(root.right); 
        } 
    }
    void preOrder(){
        preOrder(root);
    }
    void preOrder(Node node) { 
        if (node != null) { 
            pre.add(node.key);
            //System.out.print(node.key + " "); 
            preOrder(node.left); 
            preOrder(node.right); 
        } 
    }
    void postOrder(){
        postOrder(root);
    }
    void postOrder(Node node){
        if (node != null) { 
            postOrder(node.left); 
            postOrder(node.right);
            post.add(node.key);
            //System.out.print(node.key + " "); 
        }
    }
    void levelOrder() 
    { 
        int h = height(root); 
        int i; 
        for (i=1; i<=h; i++) 
            printGivenLevel(root, i); 
    } 
    void deleteKey(int key) 
    { 
        root = deleteRec(root, key); 
    } 

    int height(){
        return height(root);
    }
    int height(Node root) 
    { 
        if (root == null) 
           return 0; 
        else
        { 
            /* compute  height of each subtree */
            int lheight = height(root.left); 
            int rheight = height(root.right); 
              
            /* use the larger one */
            if (lheight > rheight) 
                return(lheight+1); 
            else return(rheight+1);  
        } 
    } 

    void printGivenLevel(Node root ,int level) 
    { 
        if (root == null) 
            return; 
        if (level == 1){
            Level.add(root.key);
           // System.out.print(root.data + " "); 
        }
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    } 
  
    /* A recursive function to insert a new key in BST */
    Node deleteRec(Node root, int key) 
    { 
        /* Base Case: If the tree is empty */
        if (root == null)  return root; 
  
        /* Otherwise, recur down the tree */
        if (key < root.key) 
            root.left = deleteRec(root.left, key); 
        else if (key > root.key) 
            root.right = deleteRec(root.right, key); 
  
        // if key is same as root's key, then This is the node 
        // to be deleted 
        else
        { 
            // node with only one child or no child 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            root.key = minValue(root.right); 
  
            // Delete the inorder successor 
            root.right = deleteRec(root.right, root.key); 
        } 
  
        return root; 
    } 

    int minValue(Node root) 
    { 
        int minv = root.key; 
        while (root.left != null) 
        { 
            minv = root.left.key; 
            root = root.left; 
        } 
        return minv; 
    } 
  
    // Driver Program to test above functions 
    
} 