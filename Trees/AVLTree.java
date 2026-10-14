


public class AVLTree {
    class Node {
        int key;
        int height;
        Node left, right;

        Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    Node root;

    // Get height of a node
    int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // Get balance factor
    int getBalance(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // Right rotation
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    // Left rotation
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    // Insert a key
    Node insert(Node node, int key) {

        // Normal BST insertion
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node; // Duplicate keys not allowed
        }

        // Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Calculate balance factor
        int balance = getBalance(node);

        // LL Case
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        // RR Case
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // LR Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Search for a key
    boolean search(Node node, int key) {
        if (node == null) {
            return false;
        }

        if (node.key == key) {
            return true;
        }

        if (key < node.key) {
            return search(node.left, key);
        }

        return search(node.right, key);
    }

    // Find minimum-valued node
    Node minValueNode(Node node) {
        Node current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // Delete a key
    Node delete(Node node, int key) {

        if (node == null) {
            return null;
        }

        // Normal BST deletion
        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {

            // Node with one child or no child
            if (node.left == null || node.right == null) {
                Node temp = (node.left != null) ? node.left : node.right;

                if (temp == null) {
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                // Node with two children
                Node temp = minValueNode(node.right);
                node.key = temp.key;
                node.right = delete(node.right, temp.key);
            }
        }

        if (node == null) {
            return null;
        }

        // Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // LL Case
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }

        // LR Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RR Case
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }

        // RL Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Inorder traversal: Left, Root, Right
    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    // Preorder traversal: Root, Left, Right
    void preorder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Postorder traversal: Left, Right, Root
    void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }

    public static void main(String[] args) {

        AVLTree tree = new AVLTree();

        int[] values = {30, 20, 10, 25, 28, 40, 50};

        for (int value : values) {
            tree.root = tree.insert(tree.root, value);
        }

        System.out.println("Inorder Traversal:");
        tree.inorder(tree.root);

        System.out.println("\n\nPreorder Traversal:");
        tree.preorder(tree.root);

        System.out.println("\n\nPostorder Traversal:");
        tree.postorder(tree.root);

        int key = 25;
        System.out.println("\n\nSearch " + key + ": " + tree.search(tree.root, key));

        tree.root = tree.delete(tree.root, 40);

        System.out.println("\nInorder after deleting 40:");
        tree.inorder(tree.root);

        System.out.println();
    }
}
