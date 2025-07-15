
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class KthLevelOfATree {
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree{
        static int idx = -1;
        public TreeNode buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static class Info{
        TreeNode node;
        int level;

        Info(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public static void printKthLevel(TreeNode node, int k){
        if (node == null) return;

        Queue<Info> q = new ArrayDeque<>();
        List<Integer> kthLevelNodes = new ArrayList<>();

        q.add(new Info(node, 1));

        while(!q.isEmpty()){
            Info curr = q.poll();
            TreeNode currNode = curr.node;
            int level = curr.level;

            if(curr.level == k){
                kthLevelNodes.add(currNode.data);
            }

            if(currNode.left != null){
                q.add(new Info(currNode.left, level+1));
            }

            if(currNode.right != null){
                q.add(new Info(currNode.right, level+1));
            }
        }

        System.out.print("Elements at kth Level are --> ");
        System.out.println(kthLevelNodes);

    }

    public static void kthLevelRecursive(TreeNode node, int level, int k){
        if(node == null) return;

        if(level == k){
            System.out.print(node.data + " ");
            return;
        }

        kthLevelRecursive(node.left, level+1, k);
        kthLevelRecursive(node.right, level+1, k);
    }


    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nodes);
        System.out.println(root.data);

        int k = 3;  //Print the level 3 elements;

        //Print the Kth Level using the Iteritive Solution
        printKthLevel(root, k);

        //Printing a next line just to keep the output clean
        System.out.println();

        //Print the kth Level using the Recursive Solution
        System.out.print("Elements at kth Level are --> ");
        kthLevelRecursive(root, 1, k);
        
    }
}
