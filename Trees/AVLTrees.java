class AVLTrees {
    static class Node {
        int data, height;
        Node left, right;

        Node(int data){
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    // Part - 6
    public static int getBalance(Node root){
        if(root == null){
            return 0;
        }

        return height(root.left) - height(root.right);
    }


    //Part-1
    public static int height(Node root){
        if(root == null){
            return 0;
        }

        return root.height;
    }

    // Part-2
    static int max(int a, int b){
        return (a > b) ? a : b;
    }


    // Part - 5
    public static Node insert (Node root, int key){
        //Check if AVL is empty
        if(root == null){
            return new Node(key);
        }

        if(key < root.data){
            root.left = insert(root.left, key); 
        } else if(key > root.data){
            root.right = insert(root.right, key);
        } else {
            return root; //duplicate keys not allowed
        }

        //update root height
        root.height = 1 + Math.max(height(root.left), height(root.right));

        //Get roots balance factor
        int bf = getBalance(root);


        //Left-Left case
        if(bf > 1 && key < root.left.data){
            return rightRotate(root);
        }

        //Right-Right case
        if(bf < -1 && key > root.right.data){
            return leftRotate(root);
        }

        //Left-Right
        if(bf > 1 && key > root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        
        //Right-Left
        if(bf < -1 && key < root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }


        return root;   //Return if AVL Balanced
    }


    //Part -7

    public static Node leftRotate(Node x){
        Node y = x.right;
        Node t2 = y.left;

        
    }

    //Part - 4
    public static void preorder(Node root){
        if(root == null){ 
            return;
        }
        System.err.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //Part - 3 
    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 60);

        /*
            AVL Tree

              30
             /  \
            20  40
           /  \   \
          10  25   50

        */

        preorder(root);
    }
}