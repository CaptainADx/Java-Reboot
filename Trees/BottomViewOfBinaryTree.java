
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {
    

    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int _data) {
            this.data = _data;
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

    public static class Tuple{
        TreeNode node;
        int col;

        public Tuple(TreeNode _node, int _col) {
            this.node = _node;
            this.col = _col;
        }
    }

    public static List<Integer> bottomView(TreeNode node){
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();

        if(node == null){
            return res;
        }

        Tuple tuple = new Tuple(node, 0);
        queue.offer(tuple);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                Tuple currTuple = queue.poll();
                TreeNode currNode = currTuple.node;
                int x = currTuple.col;

                map.put(x, currNode.data);

                if(currNode.left != null){
                    queue.add(new Tuple(currNode.left, x-1));
                }
                if(currNode.right != null){
                    queue.add(new Tuple(currNode.right, x+1));
                }
            }
        }

        for(int x : map.values()){
            res.add(x);
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, 8, -1, -1, 9, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nodes);
        System.out.println(root.data);  //Print root.data to see the data at memory location

        System.out.println(bottomView(root));
    }
}