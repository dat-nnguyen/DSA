package Tree;

import java.util.LinkedList;

import java.util.Queue;

public class BST {
    private TreeNode root;
    public BST(){
        this.root = null;
    }
    //-----------------------
    //----INSERT METHODS----
    //-----------------------
    public void insert(int key){
        root = insertRecursive(root, key);
    }
    private TreeNode insertRecursive(TreeNode node, int key){
        if (node == null){
            return new TreeNode(key);
        }// base case

        if (key < node.value) {
            node.left = insertRecursive(node.left, key); // go to the left subtree
        } else if (key > node.value) {
            node.right = insertRecursive(node.right, key);// go to the right subtree
        } // no need to resolve key == node.value
        return node;
    }

    //-----------------------
    //----SEARCH METHODS----
    //-----------------------
    public TreeNode search(int key){
        return searchRecursive(root, key);
    }
    private TreeNode searchRecursive(TreeNode node, int key){
        if(node == null) return null;

        if(key == node.value) return node;

        if(key < node.value) return searchRecursive(node.left, key);
        else return searchRecursive(node.right, key);
    }
    //-----------------------
    //------FIND MAX---------
    //-----------------------
    private int getMax(){
        if (root == null) throw new RuntimeException("Tree is empty!");

        TreeNode curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.value;
    }

    //-----------------------
    //------FIND MIN---------
    //-----------------------
    private int getMin(){
        if (root == null) throw new RuntimeException("Tree is empty!");

        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.left;
        }
        return curr.value;
    }

    //-----------------------
    //------DELETE METHOD----
    //-----------------------
    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    private TreeNode deleteRecursive(TreeNode node, int key){
        if (node == null) return null;

        if (key < node.value) {
            node.left = deleteRecursive(node.left, key);
        } else if (key > node.value) {
            node.right = deleteRecursive(node.right, key);
        } else { // find node need to delete node.val = key
            if(node.left == null && node.right == null) return null; // -> this is leaf

            if(node.left == null) return node.right; // this node has one child
            if(node.right == null) return node.left;

            // this node has two children
            int smallerValue = getMin();
            node.value = smallerValue;
            // delete
            node.right = deleteRecursive(node.left, smallerValue);
        }
        return node;
    }
    //-----------------------
    //------Get Size---------
    //-----------------------
    public int size(){
        return calculateSize(root);
    }

    private int calculateSize(TreeNode node){
        if(node == null) return 0;
        return 1 + calculateSize(node.left) + calculateSize(node.right);
    }
    //-----------------------
    //------Get Height----
    //-----------------------
    public int height(){
        return calculateHeight(root);
    }
    private int calculateHeight(TreeNode node){
        if(node == null) return -1;
        return 1 + Math.max(calculateHeight(node.left), calculateHeight(node.right));
    }
    //-----------------------
    //---------DFS----------
    //-----------------------
    public void PreOrderTraversal(){// USING STACK
        PreRecursive(root);
        System.out.println();
    }
    private void PreRecursive(TreeNode node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        PreRecursive(node.left);
        PreRecursive(node.right);
        // root -> left -> right
    }

    public void InOrderTraversal(){// USING STACK
        InRecursive(root);
        System.out.println();
        // left -> root -> right
    }
    private void InRecursive(TreeNode node) {
        if(node == null) return;
        InRecursive(node.left);
        System.out.print(node.value + " ");
        InRecursive(node.right);
    }

    public void PostOrderTraversal(){// USING STACK
        PostRecursive(root);
        System.out.println();
    }
    private void PostRecursive(TreeNode node) {
        if(node == null) return;
        PostRecursive(node.left);
        PostRecursive(node.right);
        System.out.print(node.value + " ");
        // left -> right -> root
    }

    //-----------------------
    //---------BFS-----------
    //-----------------------
    public void LevelOrderTraversal(){
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);

        while(!treeNodes.isEmpty()){
            TreeNode node = treeNodes.poll();
            System.out.print(node.value + " ");
            if(node.left != null) treeNodes.add(node.left);
            if(node.right != null) treeNodes.add(node.right);
        }
        System.out.println();
    }// USING QUEUE
}
