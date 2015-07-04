/*
 *  Java Program to Implement Binary Search Tree
 */
 
 import javax.swing.*;
 
 
 /* Class BinarySearchTree */
 public class JavaBinaryTree
 {
     public static void main(String[] args)
    {                 
        
        /* Creating object of BST */
        BST bst = new BST(); 
        JOptionPane.showMessageDialog(null,"Binary Search Tree");
        char ch;
        
        /*  Perform tree operations  */
        do    
        {
            int choice = Integer.parseInt(JOptionPane.showInputDialog("Binary Search Tree Operation\n 1. Insert\n 2. Delete\n 3. Search\n 4. Count nodes\n 5. Check tree\n"));
            switch (choice)
            {
            case 1 : 
               int insNode = Integer.parseInt(JOptionPane.showInputDialog("Enter integer element to insert node"));
               bst.insert( insNode);
                break;                          
            case 2 : 
                int delNode = Integer.parseInt(JOptionPane.showInputDialog("Enter integer element to delete node"));
                bst.delete(delNode);
                break;                         
            case 3 : 
                int serNode = Integer.parseInt(JOptionPane.showInputDialog("Enter integer element to search node"));
                JOptionPane.showMessageDialog(null, "Search result:  \"" + bst.search(serNode) +" \"");
                break;                                          
            case 4 : 
                JOptionPane.showMessageDialog(null, "Number of Nodes =  "+ bst.countNodes());
                break;     
            case 5 :  
                JOptionPane.showMessageDialog(null,"Empty status = " + bst.isEmpty());
                break;            
            default : 
                JOptionPane.showMessageDialog(null,"Wrong Entry \n");
                break;   
            }
            /*  Display tree  */ 
            System.out.print("\nPost order : ");
            bst.postorder();
            System.out.print("\nPre order : ");
            bst.preorder();
            System.out.print("\nIn order : ");
            bst.inorder();
            
           String s = JOptionPane.showInputDialog("Do you want to continue? \n (Type y or n) \n");
           ch = s.charAt(0);
        } while (ch == 'Y'|| ch == 'y');               
    }
 }
 
 /* Class BST */
 class BST
 {
     private BSTNode root;
 
     /* Constructor */
     public BST()
     {
         root = null;
     }
     /* Function to check if tree is empty */
     public boolean isEmpty()
     {
         return root == null;
     }
     /* Functions to insert data */
     public void insert(int data)
     {
         root = insert(root, data);
     }
     /* Function to insert data recursively */
     private BSTNode insert(BSTNode node, int data)
     {
         if (node == null)
             node = new BSTNode(data);
         else
         {
             if (data <= node.getData())
                 node.left = insert(node.left, data);
             else
                 node.right = insert(node.right, data);
         }
         return node;
     }
     /* Functions to delete data */
     public void delete(int k)
     {
         if (isEmpty())
            JOptionPane.showMessageDialog(null,"Binary Tree Empty");
         else if (search(k) == false)
             JOptionPane.showMessageDialog(null, "Sorry " + k + " is not present");
         else
         {
             root = delete(root, k);
             JOptionPane.showMessageDialog(null, k + " deleted form the tree");
         }
     }
     private BSTNode delete(BSTNode root, int k)
     {
         BSTNode p, p2, n;
         if (root.getData() == k)
         {
             BSTNode lt, rt;
             lt = root.getLeft();
             rt = root.getRight();
             if (lt == null && rt == null)
                 return null;
             else if (lt == null)
             {
                 p = rt;
                 return p;
             }
             else if (rt == null)
             {
                 p = lt;
                 return p;
             }
             else
             {
                 p2 = rt;
                 p = rt;
                 while (p.getLeft() != null)
                     p = p.getLeft();
                 p.setLeft(lt);
                 return p2;
             }
         }
         if (k < root.getData())
         {
             n = delete(root.getLeft(), k);
             root.setLeft(n);
         }
         else
         {
             n = delete(root.getRight(), k);
             root.setRight(n);             
         }
         return root;
     }
     /* Functions to count number of nodes */
     public int countNodes()
     {
         return countNodes(root);
     }
     /* Function to count number of nodes recursively */
     private int countNodes(BSTNode r)
     {
         if (r == null)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.getLeft());
             l += countNodes(r.getRight());
             return l;
         }
     }
     /* Functions to search for an element */
     public boolean search(int val)
     {
         return search(root, val);
     }
     /* Function to search for an element recursively */
     private boolean search(BSTNode r, int val)
     {
         boolean found = false;
         while ((r != null) && !found)
         {
             int rval = r.getData();
             if (val < rval)
                 r = r.getLeft();
             else if (val > rval)
                 r = r.getRight();
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
     /* Function for inorder traversal */
     public void inorder()
     {
         inorder(root);
     }
     private void inorder(BSTNode r)
     {
         if (r != null)
         {
             inorder(r.getLeft());
             System.out.print(r.getData() +", ");
             inorder(r.getRight());
         }
     }
     /* Function for preorder traversal */
     public void preorder()
     {
         preorder(root);
     }
     private void preorder(BSTNode r)
     {
         if (r != null)
         {
             System.out.print(r.getData() + ", ");
             preorder(r.getLeft());             
             preorder(r.getRight());
         }
     }
     /* Function for postorder traversal */
     public void postorder()
     {
         postorder(root);
     }
     private void postorder(BSTNode r)
     {
         if (r != null)
         {
             postorder(r.getLeft());             
             postorder(r.getRight());
             System.out.print(r.getData() +", ");
         }
     }     
 }
 
 /* Class BSTNode */
 class BSTNode {
     
     BSTNode left, right;
     int data;
 
     /* Constructor */
     public BSTNode()
     {
         left = null;
         right = null;
         data = 0;
     }
     /* Constructor */
     public BSTNode(int n)
     {
         left = null;
         right = null;
         data = n;
     }
     /* Function to set left node */
     public void setLeft(BSTNode n)
     {
         left = n;
     }
     /* Function to set right node */ 
     public void setRight(BSTNode n)
     {
         right = n;
     }
     /* Function to get left node */
     public BSTNode getLeft()
     {
         return left;
     }
     /* Function to get right node */
     public BSTNode getRight()
     {
         return right;
     }
     /* Function to set data to node */
     public void setData(int d)
     {
         data = d;
     }
     /* Function to get data from node */
     public int getData()
     {
         return data;
     }     
 }
