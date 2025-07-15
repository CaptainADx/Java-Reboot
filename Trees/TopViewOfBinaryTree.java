import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class TopViewOfBinaryTree {
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

    public static class InfoPair{
        TreeNode node;
        int hd;

        InfoPair(TreeNode node, int h){
            this.node = node;
            this.hd = h;
        }
    }
    
    public static void printTopViewOfTree(TreeNode root){
        if(root == null) return;
        // List<Integer> topViewElements = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<InfoPair> q = new ArrayDeque<>();

        q.offer(new InfoPair(root, 0));

        int min = 0;
        int max = 0;

        while(!q.isEmpty()){
            InfoPair curr = q.poll();
            TreeNode currNode = curr.node;
            int horizontalDist = curr.hd;

            if(!map.containsKey(horizontalDist)){
                map.put(horizontalDist, currNode.data);
            }

            if(currNode.left != null){
                q.offer(new InfoPair(currNode.left, horizontalDist-1));
                min = Math.min(min, horizontalDist-1);
            }

            if(currNode.right != null){
                q.offer(new InfoPair(currNode.right, horizontalDist+1));
                max = Math.max(max, horizontalDist+1);
            }
        }
        
        for(int i=min; i<=max; i++){
            System.out.print(map.get(i) + " ");
        }

    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nodes);
        System.out.println(root.data);

        System.out.print("Top View of Binary Tree --> ");
        printTopViewOfTree(root);
    }
}
