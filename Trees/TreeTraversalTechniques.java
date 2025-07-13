
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeTraversalTechniques {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        int idx = -1;

        public TreeNode buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1)
                return null;

            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    static void levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        queue.offer(node);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            res.add(currNode.data);
            if (currNode.left != null) {
                queue.offer(currNode.left);
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);
            }
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nodes);
        System.out.println("Root Element is --> " + root.data);

        // Doing the In-Order Traversal
        System.out.print("In-Order Traversal --> ");
        inOrder(root);
        System.out.println();

        // Doing the Pre-Order Traversal
        System.out.print("Pre-Order Traversal --> ");
        preOrder(root);
        System.out.println();

        // Doing the Post-Order Traversal
        System.out.print("Post-Order Traversal --> ");
        postOrder(root);
        System.out.println();

        // Doing the Level-Order Traversal
        System.out.print("Level-Order Traversal --> ");
        levelOrder(root);
    }
}
