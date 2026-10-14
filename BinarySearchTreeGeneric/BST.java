package BinarySearchTreeGeneric;

public class BST<T extends Comparable<T>> {
    private TreeNode<T> root;

    public boolean helper(TreeNode<T> node, T x){
        if(node == null){
            return false;
        }

        int cmp = x.compareTo(node.data);

        if(node.data == x){
            return true;
        }

        if(cmp == 0){
            return true;
        }

        if(cmp < 0){
            return helper(node.left, x);
        }
        else{
            return helper(node.right, x);
        }
    }

    public boolean isPresent(T data){
        return helper(root, data);
    }

    public void insert(T data){

    }

    public boolean delete(T data){
        return false;
    }

    public void printTreeHelper(TreeNode<T> node){
        if(root == null){
            return;
        }

        System.out.print(root.data + " : ");

        if(node.left != null){
            System.out.println("L " + node.left.data + " , ");
        }

        if(node.right != null){
            System.out.println("R " + node.right.data);
        }

        System.out.println();
        
        printTreeHelper(node.left);
        printTreeHelper(node.right);

    }

    public void printTree(){
        printTreeHelper(root);
    }


}
