import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewBinaryTree {
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

    public static class Pair{
        TreeNode node;
        int horizontalDist;

        public Pair(TreeNode _node, int _horizontalDist) {
            this.node = _node;
            this.horizontalDist = _horizontalDist;
        }
    }

    public static ArrayList<Integer> printTopViewOfTree(TreeNode node){
        ArrayList<Integer> res = new ArrayList<>();
        if(node == null) return res;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(node, 0));
        map.put(0, node.data);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                Pair pair = queue.poll();
                TreeNode currNode = pair.node;
                int currDist = pair.horizontalDist;

                if(!map.containsKey(currDist)){
                    map.put(currDist, currNode.data);
                }

                if(currNode.left != null){
                    queue.offer(new Pair(currNode.left, currDist-1));
                }

                if(currNode.right != null){
                    queue.offer(new Pair(currNode.right, currDist+1));
                }

            }
        }

        for(int x : map.values()){
            res.add(x);
        }

        return res;


    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nodes);
        System.out.println(root.data);

        System.out.print("Top View of Binary Tree --> ");
        System.out.println(printTopViewOfTree(root));
    }
}
